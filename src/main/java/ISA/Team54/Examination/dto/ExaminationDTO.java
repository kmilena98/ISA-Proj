package ISA.Team54.Examination.dto;

import java.util.Date;

public class ExaminationDTO {
	long id;
	String dermatologistName;
	String dermatologistSurname;
	Date examinationStart;
	
	
	public ExaminationDTO() {
		super();
	}


	public ExaminationDTO(long id,String dermatologistName, String dermatologistSurname, Date examinationStart) {
		super();
		this.id = id;
		this.dermatologistName = dermatologistName;
		this.dermatologistSurname = dermatologistSurname;
		this.examinationStart = examinationStart;
		
	}

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDermatologistName() {
		return dermatologistName;
	}


	public void setDermatologistName(String dermatologistName) {
		this.dermatologistName = dermatologistName;
	}


	public String getDermatologistSurname() {
		return dermatologistSurname;
	}


	public void setDermatologistSurname(String dermatologistSurname) {
		this.dermatologistSurname = dermatologistSurname;
	}


	public Date getExaminationStart() {
		return examinationStart;
	}


	public void setExaminationStart(Date examinationStart) {
		this.examinationStart = examinationStart;
	}
	
	
	
}
