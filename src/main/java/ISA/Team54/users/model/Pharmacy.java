package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.promotion.model.Promotion;
import ISA.Team54.rating.model.Rating;
import ISA.Team54.vacationAndWorkingTime.model.DermatologistWorkSchedule;

@Entity
public class Pharmacy {
	@Id
	@SequenceGenerator(name = "mySeqGen2", sequenceName = "mySeq2",initialValue = 3,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen2")
	private long id;

	@Column(unique = false, nullable = false)
	private String name;
	@Column(unique = false, nullable = false)
	private String address;
	@Column(unique = false, nullable = false)
	private String city;
	@Column(unique = false, nullable = false)
	private String country;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DermatologistWorkSchedule> dermatologistWorkingSchedules;

	@Column(nullable = false)
	private double pharmacistPrice;

	
	@JsonManagedReference
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<PharmacyAdministrator> pharmacyAdministrators;
	
	// zbog ovoga se dva puta pojavi pharmacy_id u drug in pharmacy, proveriti da li nam treba
	/*
	 * @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY) public
	 * List<DrugInPharmacy> drugs = new ArrayList<DrugInPharmacy>();
	 */

	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Promotion> promotion = new ArrayList<Promotion>();

	@ManyToMany
	@JoinTable(name = "prescriptedPatientsToPharmacies", joinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"))
	public List<Patient> subscribedPatients = new ArrayList<Patient>();

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "dermatologistsInPharmacy", joinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "dermatologist_id", referencedColumnName = "id"))
	public List<Dermatologist> dermatologists;

	@JsonBackReference
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Pharmacist> pharmacists;

	@JsonManagedReference
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Examination> examinations;
	
	@JsonManagedReference	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Rating> ratings;
	
	public Pharmacy() {
		super();
	}

	public Pharmacy(long id, String name, String address, String city, String country,
			List<PharmacyAdministrator> pharmacyAdministrators, List<Promotion> promotion,
			List<Patient> subscribedPatients, List<Dermatologist> dermatologists, List<Pharmacist> pharmacists,
			List<Examination> examinations) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.pharmacyAdministrators = pharmacyAdministrators;

		this.promotion = promotion;
		this.subscribedPatients = subscribedPatients;
		this.dermatologists = dermatologists;
		this.pharmacists = pharmacists;
		this.examinations = examinations;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public List<PharmacyAdministrator> getPharmacyAdministrators() {
		return pharmacyAdministrators;
	}

	public void setPharmacyAdministrators(List<PharmacyAdministrator> pharmacyAdministrators) {
		this.pharmacyAdministrators = pharmacyAdministrators;
	}

	public List<Promotion> getPromotion() {
		return promotion;
	}

	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}

	public List<Patient> getSubscribedPatients() {
		return subscribedPatients;
	}

	public void setSubscribedPatients(List<Patient> subscribedPatients) {
		this.subscribedPatients = subscribedPatients;
	}

	public List<Dermatologist> getDermatologists() {
		return dermatologists;
	}

	public void setDermatologists(List<Dermatologist> dermatologists) {
		this.dermatologists = dermatologists;
	}

	public List<Pharmacist> getPharmacists() {
		return pharmacists;
	}

	public void setPharmacists(List<Pharmacist> pharmacists) {
		this.pharmacists = pharmacists;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}
	
	public double getRatings() {
		double rating = 0;
		int count = 0;
		for (Rating r : ratings) {
			rating += r.getRating();
			count++;
		}
		return count != 0 ? (double)rating/count : 0;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public double getPharmacistPrice() {
		return pharmacistPrice;
	}

	public void setPharmacistPrice(double pharmacistPrice) {
		this.pharmacistPrice = pharmacistPrice;
	}
	
}
