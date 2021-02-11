package ISA.Team54.drugAndRecipe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import ISA.Team54.users.model.Patient;
@Entity
public class DrugAllergy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	private Drug drug;

	
	@OneToOne(fetch = FetchType.LAZY)
	private Patient patient;

	public DrugAllergy() {
		super();
	}

	public DrugAllergy(long id, Drug drug, Patient patient) {
		super();
		this.id = id;
		this.drug = drug;
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
