package ISA.Team54.Examination.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Embeddable
public class Term {
	 
	 private Date start;
	 
	 private int duration;		
	 
	public Term() {
		super();
	}
	public Term(Date start, int duration) {
		super();
		this.start = start;
		this.duration = duration;
	}	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}	 	 
}

