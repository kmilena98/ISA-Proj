package ISA.Team54.Examination.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.enums.ExaminationType;
import ISA.Team54.Examination.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
	public List<Examination> findAll();
	public List<Examination> findByPatientId(Long patientId);
	public List<Examination> findByEmplyeedIdAndStatus(Long id,ExaminationStatus es);
	
	public Examination findById(int id);
	public Examination findOneById(Long id);
	public List<Examination> findByEmplyeedId(Long id);
	public List<Examination> findByEmplyeedIdAndPharmacyId(Long emplyeedId,Long pharmacyId);
	public List<Examination> findByEmplyeedIdAndStatusAndPharmacyId(Long emplyeedId,ExaminationStatus es,Long pharmacyId);
	
	@Query("SELECT e FROM Examination e where emplyeed_id = ?1 and status = ?2 and cast(start as java.util.Date) > ?3 and  cast(start as java.util.Date) < ?4") 
	List<Examination> getSoonestDates(long id, ExaminationStatus ex, Date before, Date after);
	
	@Query("SELECT e FROM Examination e where patient_id = ?1 and type = ?2  and start < CURRENT_TIMESTAMP") 
	List<Examination> getHistoryExaminationsForPatient(long id, ExaminationType type);
	
	@Query("SELECT e FROM Examination e where pharmacy_id = ?1 and type = ?2 and status = ?3 ")
	List<Examination> getAllExaminationsForPharmacy(long id, ExaminationType type, ExaminationStatus status);
	
	@Query("SELECT e FROM Examination e where pharmacy_id = ?1 and type = ?2 and status = ?3 and cast(start as java.util.Date) = ?4 ")
	List<Examination> getExaminationsForPharmacyForDate(long id, ExaminationType type, ExaminationStatus status, Date date);
	
	@Query("SELECT e FROM Examination e where patient_id = ?1 and type = ?2 and status = ?3 and start > CURRENT_TIMESTAMP") 
	List<Examination> getFutureExaminations(long id, ExaminationType type, ExaminationStatus status);
	
	@Query("select e from Examination e where cast(start as java.util.Date) = ?1 and type = ?2 and status='Unfilled'")
	public List<Examination> getFreeExaminationsForInterval(Date term, ExaminationType type);
	
}
