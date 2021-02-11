package ISA.Team54.users.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.service.interfaces.ExaminationService;
import ISA.Team54.users.dto.DermatologistPatientDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.users.dto.BasicPatientInfoDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.dto.PatientDTO;
import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.exceptions.AllergyAlreadyAddedException;
import ISA.Team54.users.mapper.PatientMapper;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.PatientService;

@RestController
@RequestMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private ExaminationService examinationSerivce;
	
	@GetMapping("patientBySurnameAndName/{surnameAndName}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<PatientDTO> loadBySurnameAndName(@PathVariable String surnameAndName){
		List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
		for(User user : this.patientService.findBySurnameAndName(surnameAndName)) 
			patientsDTO.add(new PatientMapper().UserToPatientDTO(user));
		return patientsDTO;
	}
	
	@PostMapping("/addPenaltyPoint/{patientId}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public ResponseEntity<String> addPenaltyPoints(@PathVariable Long patientId){
		try {
			patientService.addPenaltyPointForPatient(patientId);
			return new ResponseEntity<>("Penalty poenti pacijenta su uspesno izmenjeni!",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
	}
	@GetMapping("/allPatients/")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<PatientDTO> loadPatients(){
		List<PatientDTO> patientsDTO = new ArrayList<PatientDTO>();
		for(User user : this.patientService.findAll()) 
			patientsDTO.add(new PatientMapper().UserToPatientDTO(user));
		return patientsDTO;
	}
	
	
	// pacients that were examinated by dermatologist / dermatologistID
	@GetMapping("examinatedPatients/")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<DermatologistPatientDTO> loadBySurnameAndName(){
		List<DermatologistPatientDTO> dermatologistPatientsDTO = new ArrayList<DermatologistPatientDTO>();
		List<Examination> dermatologistExaminations = examinationSerivce.getAllExaminatedExaminationsForEmployee();
		if(dermatologistExaminations != null) {
			for(Examination examination : dermatologistExaminations) 
				dermatologistPatientsDTO.add(new PatientMapper().PatientToDermatologistPatientDTO(examination,examination.getPatient()));
		}		
		return dermatologistPatientsDTO;
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('PATIENT')")
	public Patient loadById(@PathVariable long id){
		System.out.println(id);
		return this.patientService.findById(id);
	}
	
	@PutMapping("")
	@PreAuthorize("hasRole('PATIENT')")
	public void updatePatient(@RequestBody UserInfoDTO user){
		this.patientService.updatePatient(user);
	} 
	
	@GetMapping("/allergies/{id}")
	@PreAuthorize("hasRole('PATIENT')")
	public List<Drug> getPatientAllergies(@PathVariable long id){
		return this.patientService.getPatientAllergies(id);
	}
	
	@DeleteMapping("/allergies/{id}")
	@PreAuthorize("hasRole('PATIENT')")
	public void deletePatientAllergy(@PathVariable long id){
		this.patientService.deletePatientAllergy(id);
	}
	
	@PostMapping("/allergies/{id}")
	@PreAuthorize("hasRole('PATIENT')")
	public ResponseEntity<String> addAllegy(@PathVariable long id){
		try {
			patientService.addAllergy(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(AllergyAlreadyAddedException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
