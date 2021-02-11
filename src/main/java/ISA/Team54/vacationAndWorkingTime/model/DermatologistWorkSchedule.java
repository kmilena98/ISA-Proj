package ISA.Team54.vacationAndWorkingTime.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.shared.model.DateRange;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacy;
@Entity
public class DermatologistWorkSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DateRange timePeriod;
	
	@JsonBackReference(value="clinci_movement")
	@OneToOne()
	private Dermatologist dermatologist;
	
	@JsonBackReference	
	@OneToOne()
	private Pharmacy pharmacy;
	
	public DermatologistWorkSchedule() {
		super();
	}

	public DermatologistWorkSchedule(Long id, DateRange timePeriod, Dermatologist dermatologist, Pharmacy pharmacy) {
		super();
		this.id = id;
		this.timePeriod = timePeriod;
		this.dermatologist = dermatologist;
		this.pharmacy = pharmacy;
	}

	public DateRange getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(DateRange timePeriod) {
		this.timePeriod = timePeriod;
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

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
}
