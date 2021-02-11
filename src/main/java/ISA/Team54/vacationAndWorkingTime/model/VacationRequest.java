package ISA.Team54.vacationAndWorkingTime.model;

import javax.persistence.*;

import ISA.Team54.shared.model.DateRange;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.vacationAndWorkingTime.enums.VacationRequestStatus;
@Entity
public class VacationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DateRange timePeriod;
	
	@Enumerated(EnumType.STRING)
	private VacationRequestStatus status;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Dermatologist dermatologist;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacist pharmacist;

	public VacationRequest() {
		super();
	}

	public VacationRequest( DateRange timePeriod, VacationRequestStatus status, Dermatologist dermatologist,
			Pharmacist pharmacist) {
		super();
		this.timePeriod = timePeriod;
		this.status = status;
		this.dermatologist = dermatologist;
		this.pharmacist = pharmacist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateRange getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(DateRange timePeriod) {
		this.timePeriod = timePeriod;
	}
	
	public VacationRequestStatus getStatus() {
		return status;
	}

	public void setStatus(VacationRequestStatus status) {
		this.status = status;
	}
	
	public Dermatologist getDermatologist() {
		return dermatologist;
	}

	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

	public Pharmacist getPharmacist() {
		return pharmacist;
	}

	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

}
