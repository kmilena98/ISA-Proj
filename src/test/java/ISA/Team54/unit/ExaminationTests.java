package ISA.Team54.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.Examination.repository.ExaminationRepository;

public class ExaminationTests {

	@MockBean
	private ExaminationRepository doctorRepositoryMocked;
	
	/*
	 * @Test public void findOneByIdTest() { Examinaiton examination = new
	 * Examination(); examination.setId(DoctorConstants.DOCTOR_ID);
	 * Mockito.when(doctorRepositoryMocked.findOneById(doctorTest.getId())).
	 * thenReturn(doctorTest); MedicalWorker doctor =
	 * doctorService.findOneById(DoctorConstants.DOCTOR_ID);
	 * assertEquals(DoctorConstants.DOCTOR_ID, doctor.getId()); }
	 */
}
