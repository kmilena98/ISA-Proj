package ISA.Team54.drugOrdering.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.users.enums.OfferStatus;
import ISA.Team54.users.model.Supplier;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false)
	private double totalPrice;
	
	@Column(unique = false)
	private Date deliveryDeadline;
	
	@Column(unique = false)
	private OfferStatus status;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Supplier supplier;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DrugsOrder order;
	
	
	
}
