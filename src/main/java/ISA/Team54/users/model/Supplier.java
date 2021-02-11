package ISA.Team54.users.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ISA.Team54.drugAndRecipe.model.DrugInStorage;
import ISA.Team54.drugOrdering.model.Offer;

@Entity
public class Supplier extends User{
	
	@OneToMany(mappedBy="supplier",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Offer> offer = new ArrayList<Offer>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<DrugInStorage> drugsInStorage = new ArrayList<DrugInStorage>();
	
	public Supplier() {
		super();
	}

	public Supplier(long id, String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, List<Offer> offer) {
		super(id, email, password, name, surname, address, city, country, phoneNumber);
		this.offer = offer;
	}

	public List<Offer> getOffer() {
		return offer;
	}

	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}	
	
}
