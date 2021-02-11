package ISA.Team54.users.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ISA.Team54.users.enums.ComplaintType;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = false,nullable = false)
	private String text;
	
	@Column(unique = false,nullable = false)
	private int objectId;
	
	@Enumerated
	private ComplaintType type;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Patient patient;
	
	public Complaint() {
		super();
	}

	public Complaint(Long id, String text, Patient patient) {
		super();
		this.id = id;
		this.text = text;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
