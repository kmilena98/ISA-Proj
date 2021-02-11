package ISA.Team54.users.service.implementations;

import java.util.ArrayList;
import java.util.List;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.repository.ExaminationRepository;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.users.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.dto.DrugWithPharmacyDTO;
import ISA.Team54.security.Authority;
import ISA.Team54.users.dto.DermatologistRequestDTO;
import ISA.Team54.users.dto.PharmacistRequestDTO;
import ISA.Team54.users.dto.PharmacyAdministratorRequestDTO;
import ISA.Team54.users.dto.PharmacyDTO;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.mappers.PharmacyMapper;
import ISA.Team54.users.mappers.UserMapper;
import ISA.Team54.users.repository.DermatologistRepository;
import ISA.Team54.users.repository.PatientRepository;
import ISA.Team54.users.repository.PharmacyAdministratorRepository;
import ISA.Team54.users.repository.PharmacyRepository;
import ISA.Team54.users.repository.SupplierRepository;
import ISA.Team54.users.repository.SystemAdministratorRepository;
import ISA.Team54.users.service.interfaces.AuthorityService;
import ISA.Team54.users.service.interfaces.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PharmacyAdministratorRepository pharmacyAdministratorRepository;
	
	@Autowired
	private SystemAdministratorRepository systemAdministratorRepository;
	
	@Autowired
	private DermatologistRepository dermatologistRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;

	@Autowired
	private PharmacyRepository pharmacyRepository;

	@Autowired
	private ExaminationRepository examinationRepository;
	
	@Override
	public Pharmacy addPharmacy(PharmacyDTO pharmacyDTO) {
		return pharmacyRepository.save(PharmacyMapper.PharmacyDTOToPharmacy(pharmacyDTO));		
	} 
	
	@Override
	public Patient addPatient(UserRequestDTO userRequest) {
		Patient patient = new Patient();
		UserMapper.UserRequestDTOToUser(userRequest,patient);
		patient.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_PATIENT");
		patient.setAuthorities(auth);
		return patientRepository.save(patient);		
	}
	
	@Override
	public SystemAdministrator addSystemAdministrator(UserRequestDTO userRequest) {
		SystemAdministrator systemAdministrator = new SystemAdministrator();
		UserMapper.UserRequestDTOToUser(userRequest,systemAdministrator);
		systemAdministrator.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_SISTEM_ADMIN");
		systemAdministrator.setAuthorities(auth);
		return systemAdministratorRepository.save(systemAdministrator);			
	}
	
	@Override
	public Supplier addSupplier(UserRequestDTO userRequest) {
		Supplier supplier = new Supplier();
		UserMapper.UserRequestDTOToUser(userRequest,supplier);	
		supplier.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_SUPPLIER");
		supplier.setAuthorities(auth); 
		return supplierRepository.save(supplier);			
	}

	@Override
	public PharmacyAdministrator addPharmacyAdministrator(
		PharmacyAdministratorRequestDTO pharmacyAdministratorRequestDTO) {
		PharmacyAdministrator pharmacyAdministrator = UserMapper.PharmacyAdministratorRequestDTOToPharmacist(pharmacyAdministratorRequestDTO);
		pharmacyAdministrator.setPassword(passwordEncoder.encode(pharmacyAdministratorRequestDTO.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_ADMIN");
		pharmacyAdministrator.setAuthorities(auth);
		pharmacyAdministrator.setPharmacy(pharmacyRepository.findById(pharmacyAdministratorRequestDTO.getPharmacyId()));
		return pharmacyAdministratorRepository.save(pharmacyAdministrator);			

	}

	@Override
	public Dermatologist addDermatologist(DermatologistRequestDTO dermatologistRequestDTO) {
		Dermatologist dermatologist = UserMapper.DermatologistRequestDTOToDermatologist(dermatologistRequestDTO);
		dermatologist.setPassword(passwordEncoder.encode(dermatologistRequestDTO.getPassword()));
		List<Authority> auth = authService.findByname("ROLE_DERMATOLOGIST");
		dermatologist.setAuthorities(auth);
		return dermatologistRepository.save(dermatologist);	
	}

	@Override
	public Pharmacist addPharmacist(PharmacistRequestDTO pharmacistRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pharmacy getPharmacyById(long pharmacyId) {
		return pharmacyRepository.findById(pharmacyId);
	}

	public List<Pharmacy> findAll() {
		return this.pharmacyRepository.findAll();
	}

	@Override
	public List<Pharmacy> getPatientPharmacies(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());

		List<Examination> examinations =  examinationRepository.findByPatientId(patient.getId());
		List<Pharmacy> pharmacies = new ArrayList<Pharmacy>();
		examinations.forEach(e -> pharmacies.add(e.getPharmacy()));

		return pharmacies;
	}

}
