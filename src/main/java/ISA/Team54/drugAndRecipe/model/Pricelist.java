package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.shared.model.DateRange;


@Entity
public class Pricelist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false, nullable = false)
	private float price;
	
	// period vazenja cene dateRange i da li to pokriva i deo : Prilikom generisanja
	// izveštaja o prihodima apoteke, u obzir se uzima cena leka za datum prodaje

	@Embedded
	private DateRange priceValidDataRange;

	
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	 private DrugInPharmacy drugInPharmacy;
	 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pricelist() {
		super();
	}

	public Pricelist(long id, float price) {
		super();
		this.id = id;
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
