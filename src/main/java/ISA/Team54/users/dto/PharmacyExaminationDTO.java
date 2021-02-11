package ISA.Team54.users.dto;

import java.util.Date;

import ISA.Team54.Examination.enums.ExaminationType;

public class PharmacyExaminationDTO {
	private long id;
	private ExaminationType type;
	private Date date;
	
	public PharmacyExaminationDTO() {
		super();
	}
	
	public PharmacyExaminationDTO(long id, ExaminationType type, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ExaminationType getType() {
		return type;
	}
	public void setType(ExaminationType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
