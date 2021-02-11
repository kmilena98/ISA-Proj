package ISA.Team54.rating.model;

import javax.persistence.*;
import javax.validation.constraints.Null;

import ISA.Team54.users.model.Patient;
import com.fasterxml.jackson.annotation.JsonBackReference;

import ISA.Team54.rating.enums.RatingObject;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.model.Pharmacy;
import org.springframework.lang.Nullable;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference
	@ManyToOne
	@Nullable
	private Dermatologist dermatologist;
	
	@JsonBackReference
	@ManyToOne
	@Nullable
	private Pharmacist pharmacist;
	
	@JsonBackReference
	@ManyToOne
	@Nullable
	private Pharmacy pharmacy;

	@OneToOne
	private Patient patient;
	
	@Column(unique = false,nullable = false)
	private double rating;
	
	public Rating() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatoligist) {
		this.dermatologist = dermatoligist;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
