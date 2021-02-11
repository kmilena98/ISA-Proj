package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.users.model.Pharmacy;

@Entity
public class DrugInPharmacy {
	@EmbeddedId
	private DrugInPharmacyId drugInPharmacyId;

	@Column(unique = false, nullable = true)
	private int quantity;	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "reservedDrug", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DrugReservation> drugReservations = new ArrayList<DrugReservation>();

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Pricelist pricelist;
	
	public DrugInPharmacy() {
		super();
	}

	public DrugInPharmacy(DrugInPharmacyId drugInPharmacyId, int quantity) {
		super();
		this.drugInPharmacyId = drugInPharmacyId;
		this.quantity = quantity;
	}

	public DrugInPharmacyId getDrugInPharmacyId() {
		return drugInPharmacyId;
	}

	public void setDrugInPharmacyId(DrugInPharmacyId drugInPharmacyId) {
		this.drugInPharmacyId = drugInPharmacyId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<DrugReservation> getDrugReservations() {
		return drugReservations;
	}

	public void setDrugReservations(List<DrugReservation> drugReservations) {
		this.drugReservations = drugReservations;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}
	
	

	 

}
