package ISA.Team54.users.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.drugOrdering.model.DrugsOrder;

@Entity
public class PharmacyAdministrator extends User{

	@JsonManagedReference
	@OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DrugsOrder> drugOrders;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pharmacy pharmacy;
	
	public PharmacyAdministrator() {
		
	}

	public PharmacyAdministrator(long id, String email, String password, String name, String surname, String address,
			String city, String country, String phoneNumber, List<DrugsOrder> drugOrder,Pharmacy pharmacy) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.drugOrders = drugOrder;
		this.pharmacy = pharmacy;
	}

	public List<DrugsOrder> getDrugOrders() {
		return drugOrders;
	}

	public void setDrugOrders(List<DrugsOrder> drugOrders) {
		this.drugOrders = drugOrders;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	

}
