package ISA.Team54.drugAndRecipe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.drugAndRecipe.dto.IsAvalableDrugDTO;
import ISA.Team54.drugAndRecipe.mapper.DrugMapper;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;
import ISA.Team54.drugAndRecipe.model.DrugSpecification;
import ISA.Team54.drugAndRecipe.repository.DrugAllergyRepository;
import ISA.Team54.drugAndRecipe.repository.DrugRepository;
import ISA.Team54.drugAndRecipe.repository.DrugsInPharmacyRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugService;
import ISA.Team54.shared.service.interfaces.EmailService;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugRepository drugRepository;
	@Autowired
	private ExaminationRepository examinationRepository;
	@Autowired
	private DrugAllergyRepository drugAllergyRepsoitory;
	@Autowired
	private DrugsInPharmacyRepository drugsInPharmacyRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<Drug> getDrugsForPatient(Long id) {
		List<Drug> allDrugs = drugRepository.findAll();
		List<Drug> drugsForPatient = new ArrayList<Drug>();
		if(allDrugs== null) 
			return new ArrayList<Drug>();
		
		
		for(Drug drugAllergy : allDrugs) {
			if(isPatientAlergicOnDrug(id,drugAllergy.getId())) {
				drugsForPatient.add(drugAllergy);
			}
			
		}
		return drugsForPatient;
	}
	
	private boolean isPatientAlergicOnDrug(Long patientId, Long drugId) {
		Drug drug = drugRepository.findOneById(drugId);
		Patient patient = patientRepository.findOneById(patientId);
		for(Drug allergyDrug : patient.getDrugAllergies()) {
			if(drug.getId()==allergyDrug.getId()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isDrugAvailable(Long drugId, Examination examination) {
		
		DrugInPharmacy drugInPharmacy = drugsInPharmacyRepository.findOneByDrugInPharmacyId(new DrugInPharmacyId(examination.getPharmacy().getId(),drugId));
		if(drugInPharmacy != null && drugInPharmacy.getQuantity()>0) {
			drugInPharmacy.setQuantity(drugInPharmacy.getQuantity() - 1);
			return true;
		}
		return false;
	}
	
	public IsAvalableDrugDTO findOrFindSubstitute(long drugId, long examinationId) {
		Examination examination = examinationRepository.findOneById(examinationId);
		Patient patient = examination.getPatient();
		IsAvalableDrugDTO availableDTO = new IsAvalableDrugDTO();
		boolean isAvailable = isDrugAvailable(drugId,examination);
		if(isAvailable) {
			availableDTO.setAvailable(true);
			return availableDTO;
		}
		Drug missingDrug = drugRepository.findOneById(drugId);
		emailService.sendEmail("team54isa@gmail.com","MANJAK LEKA","-- LEK --  ime :"+missingDrug.getName()+" code :" + missingDrug.getCode() + " nedostaje u bolnici");
		List<Drug> substituteDrugsForPatient = new ArrayList<Drug>();
		Drug mainDrug = drugRepository.findOneById((long)drugId);
		List<Drug> substituteDrugs = mainDrug.getMainDrugs();
		for(Drug substituteDrug : substituteDrugs) {
			if(isDrugAvailable((long)substituteDrug.getId(),examination) && isPatientAlergicOnDrug(patient.getId(),(long)substituteDrug.getId())) {
				substituteDrugsForPatient.add(substituteDrug);
			}
		}		
		availableDTO.setAvailable(false);  
		for(Drug drug : substituteDrugsForPatient) {
			availableDTO.getDrugsDTO().add(new DrugMapper().DrugIntoDrugDTO(drug));
		}
		return availableDTO;
	}

	public void reduceDrugQuantityInPharmacy(long drugId, int pharmacyId,int quantity) {
		DrugInPharmacy drugInPharmacy = drugsInPharmacyRepository.findOneByDrugInPharmacyId(new DrugInPharmacyId(pharmacyId,drugId));
		drugInPharmacy.setQuantity(drugInPharmacy.getQuantity()-quantity);
		drugsInPharmacyRepository.save(drugInPharmacy);
	}

	@Override
	public DrugSpecification getSpecificationForDrug(Long drugId) {
		Drug drug = drugRepository.findOneById(drugId);
		if(drug!=null) {
			return drug.getDrugSpecification();
		}
		return null;
	}
	@Override
	public List<Drug> getAllDrugs() {
		return drugRepository.findAll();
	}

	@Override
	public Drug findById(long id) {
		return drugRepository.findById(id).orElse(null);
	}

	@Override
	public List<Drug> getSubstituteForDrug(Long drugId) {
		Drug mainDrug = drugRepository.findOneById((long)drugId);
		 return mainDrug.getMainDrugs();
	}
	
}
