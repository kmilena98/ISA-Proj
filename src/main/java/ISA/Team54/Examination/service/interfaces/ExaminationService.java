package ISA.Team54.Examination.service.interfaces;
import java.util.Date;
import java.util.List;

import ISA.Team54.Examination.dto.DermatologistExaminationDTO;
import ISA.Team54.Examination.dto.ExaminationForCalendarDTO;
import ISA.Team54.Examination.dto.ExaminationInformationDTO;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.enums.UserRole;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.users.model.User;

public interface ExaminationService {
	Examination getCurrentExaminationForEmployee();
	List<Examination> historyOfPatientExamination(Long id);
	void updateExamination(ExaminationInformationDTO examinationInformationDTO);
	List<Examination> getAllExaminatedExaminationsForEmployee();
	List<Examination> getDefinedExaminations();
	List<DermatologistExaminationDTO> getAllExaminationsForPharmacy(long id, ExaminationType type);
	List<DermatologistExaminationDTO> getExaminationsForPharmacyAndDate(long id, ExaminationType type, Date date);
	void scheduleExamination(long id);
	boolean canExaminationBeScheduled(Examination examination, Date start,Date end);
	boolean scheduleExamination(Date start);
	void cancelExamination(long id) throws Exception;
	boolean saveExamination(Long newExaminationId);
	List<DermatologistExaminationDTO> getFutureExaminations(ExaminationType type);
	List<Pharmacy> getFreePharmaciesForInterval(Date term, ExaminationType type);
	int isPatientAppropriate(Long patientId);
    List<User> getEmployeeWhoExaminedPatient(ExaminationType type);
	List<ExaminationForCalendarDTO> getExaminaitonForCalendar();
	UserRole getCurrentRole();
	Long getCurrentEmployedId();
}
