package ISA.Team54.promotion.model;

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
import ISA.Team54.users.model.Pharmacy;

@Entity
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String description;
	
	@Embedded
	private DateRange dateInterval;
	
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
	private Pharmacy pharmacy;
}
