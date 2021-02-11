package ISA.Team54.users.mapper;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.dto.DermatologistPatientDTO;
import ISA.Team54.users.dto.PatientDTO;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;

public class PatientMapper {

	public  PatientDTO UserToPatientDTO(User user) {
		return new PatientDTO((int)user.getId(),user.getName(), user.getSurname());
	}
	
	public DermatologistPatientDTO PatientToDermatologistPatientDTO(Examination examination,Patient patient) {
		return  new DermatologistPatientDTO((int)patient.getId(),patient.getName(),patient.getSurname(),examination.getTerm().getStart());
		
	}
}
