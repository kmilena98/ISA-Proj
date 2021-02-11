package ISA.Team54.Examination.dto;

import java.util.Date;

import ISA.Team54.Examination.enums.ExaminationType;

public class ExaminationSearchDTO {
	private Date date;
	private ExaminationType type;
	
	public ExaminationSearchDTO() {
		super();
	}
	
	
	public ExaminationSearchDTO(Date date, ExaminationType type) {
		super();
		this.date = date;
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public ExaminationType getType() {
		return type;
	}
	public void setType(ExaminationType type) {
		this.type = type;
	}

}
