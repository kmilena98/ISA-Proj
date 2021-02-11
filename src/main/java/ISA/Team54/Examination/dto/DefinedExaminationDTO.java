package ISA.Team54.Examination.dto;

import java.util.Date;

public class DefinedExaminationDTO {
	private long examinationId;
	private Date examinationStart;
	private int price;
	public DefinedExaminationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DefinedExaminationDTO(long id,Date examinationStart, int price) {
		super();
		this.examinationId = id;
		this.examinationStart = examinationStart;
		this.price = price;
	}
	public Date getExaminationStart() {
		return examinationStart;
	}
	public void setExaminationStart(Date examinationStart) {
		this.examinationStart = examinationStart;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getExaminationId() {
		return examinationId;
	}
	public void setExaminationId(long examinationId) {
		this.examinationId = examinationId;
	}
	
	
}
