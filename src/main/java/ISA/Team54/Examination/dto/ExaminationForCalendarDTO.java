package ISA.Team54.Examination.dto;

import java.util.Date;

public class ExaminationForCalendarDTO {
	private Long id;
	private Long patientId;
	private Date start;
	private int duration;
	private String pharmacyName;
	private String patientName;
	private String patientSurname;
	public ExaminationForCalendarDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExaminationForCalendarDTO(Long id,Long patientId,Date start, int duration, String pharmacyName, String patientName,
			String patientSurname) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.start = start;
		this.duration = duration;
		this.pharmacyName = pharmacyName;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
	}
	
	
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
}
