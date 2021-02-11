package ISA.Team54.drugAndRecipe.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

import ISA.Team54.drugAndRecipe.enums.ReservationStatus;
import ISA.Team54.users.model.Patient;

@Entity
public class DrugReservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = true)
	private Date reservationToDate;
	
	@Column(unique = false,nullable = true)
	private ReservationStatus status; 
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Patient patient;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DrugInPharmacy reservedDrug;
	
	public DrugReservation() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getReservationToDate() {
		return reservationToDate;
	}

	public void setReservationToDate(Date reservationToDate) {
		this.reservationToDate = reservationToDate;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public DrugInPharmacy getReservedDrug() {
		return reservedDrug;
	}

	public void setReservedDrug(DrugInPharmacy reservedDrug) {
		this.reservedDrug = reservedDrug;
	}
	
}
