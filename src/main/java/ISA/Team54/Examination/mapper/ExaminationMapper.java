package ISA.Team54.Examination.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.dto.ExaminationDTO;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.DermatologistService;
import ISA.Team54.users.service.interfaces.UserService;

public class ExaminationMapper {

	@Autowired
	private DermatologistService dermatologsitService;
	@Autowired
	private UserService userService;
	
	public ExaminationDTO ExaminationToExaminationDTO(Examination examination) {
		return new ExaminationDTO(examination.getId(),examination.getPatient().getName(),examination.getPatient().getSurname(),examination.getTerm().getStart());
	}
	public DermatologistExaminationDTO ExaminationToDermatologistExaminationDTO(Examination examination, User user, ExaminationType type) {
		double rating;
		if(type.equals(ExaminationType.DermatologistExamination))
			rating = ((Dermatologist)user).getRatings();
		else rating = ((Pharmacist)user).getRatings();
		
		return new DermatologistExaminationDTO(
				examination.getId(), 
				examination.getTerm(), 
				user.getName() + " " + user.getSurname(), 
				rating,
				examination.getPrice());
	}
	public ExaminationDTO ExaminationToExaminationDTOHistory(Examination examination,User user) {
		if(user != null) 
		{
			return new ExaminationDTO(examination.getId(),user.getName(),user.getSurname(),examination.getTerm().getStart());
			
		}
		return null;
		}

}
