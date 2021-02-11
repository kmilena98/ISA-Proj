package ISA.Team54.shared.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class DateRange {
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	
	public DateRange() {
		super(); 
	}


	public DateRange(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}	
	public boolean isTheDateBetweenDates(Date date) {
		boolean a = date.compareTo(this.startDate) >= 0;
		boolean b = date.compareTo(this.endDate) < 0; 
	return 	a && b;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public boolean isInRange(DateRange workingTime) {
		int workingDayEnd = workingTime.getStartDate().getHours() *60 + workingTime.getStartDate().getMinutes();
		int workingDayStart = workingTime.getEndDate().getHours()*60 +workingTime.getEndDate().getMinutes() ;
		int examinationStart = this.startDate.getHours()*60 + this.startDate.getMinutes();
		int examinationEnd = (int)this.endDate.getHours()*60+(int)this.endDate.getMinutes();
		
		if(examinationStart>=workingDayStart && examinationStart < workingDayEnd && examinationEnd>workingDayStart && examinationEnd<=workingDayEnd)
			return true;
		return false;
	}
	
	public boolean areOverlapping(DateRange time) {
		if(isTheDateBetweenDates(time.getStartDate()) || isTheDateBetweenDates(time.getEndDate()))
			return false;
		return true;
	}
}
