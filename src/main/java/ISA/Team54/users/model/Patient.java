package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugAllergy;
import ISA.Team54.drugAndRecipe.model.DrugReservation;
import ISA.Team54.drugAndRecipe.model.ERecipe;

@Entity
public class Patient extends User {

	
	@Column(unique = false, nullable = true)
	private int penaltyPoints;

	@Column(unique = false, nullable = true)
	private int loyaltyPoints;

	@JsonManagedReference
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ERecipe> eRecipes;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "drug_allergies", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "drug_id", referencedColumnName = "id"))
	public List<Drug> drugAllergies;

	@JsonManagedReference
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Complaint> complaints;
	
	@JsonManagedReference
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<DrugReservation> drugReservations;	
	
	@ManyToMany(mappedBy= "subscribedPatients")
	private List<Pharmacy> prescriptionsPharmacies;
	
	@JsonManagedReference
	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private List<Examination> examinations;

	public Patient() {
		super();
	}

	public int getPenaltyPoints() {
		return penaltyPoints;
	}

	public void setPenaltyPoints(int penaltyPoints) {
		this.penaltyPoints = penaltyPoints;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public List<ERecipe> geteRecipes() {
		return eRecipes;
	}

	public void seteRecipes(List<ERecipe> eRecipes) {
		this.eRecipes = eRecipes;
	}

	public List<Drug> getDrugAllergies() {
		return drugAllergies;
	}

	public void setDrugAllergies(List<Drug> drugAllergies) {
		this.drugAllergies = drugAllergies;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public List<DrugReservation> getDrugReservations() {
		return drugReservations;
	}

	public void setDrugReservations(List<DrugReservation> drugReservations) {
		this.drugReservations = drugReservations;
	}

	public List<Pharmacy> getPrescriptionsPharmacies() {
		return prescriptionsPharmacies;
	}

	public void setPrescriptionsPharmacies(List<Pharmacy> prescriptionsPharmacies) {
		this.prescriptionsPharmacies = prescriptionsPharmacies;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	

	
	
}
