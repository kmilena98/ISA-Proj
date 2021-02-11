package ISA.Team54.users.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.rating.model.Rating;
import ISA.Team54.shared.model.DateRange;
import ISA.Team54.vacationAndWorkingTime.model.DermatologistWorkSchedule;
import ISA.Team54.vacationAndWorkingTime.model.VacationRequest;

@Entity
public class Pharmacist extends User{
	
	@JsonManagedReference	
	@OneToMany(mappedBy = "pharmacist", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Rating> ratings;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Pharmacy pharmacy;
	
	@Embedded
	private DateRange workSchedule;
	
	@OneToMany(mappedBy="pharmacist",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<VacationRequest> vacationRequest;
	
	public Pharmacist() {
		super();
	}
	

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public DateRange getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(DateRange workSchedule) {
		this.workSchedule = workSchedule;
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
}
