package ISA.Team54.Examination.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ScheduleExaminaitonDTO {
	private Date date;
	
	public ScheduleExaminaitonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleExaminaitonDTO( Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
