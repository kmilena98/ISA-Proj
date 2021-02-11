package ISA.Team54.drugAndRecipe.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.users.model.Pharmacy;
@Entity
public class DrugDeficitQuery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = false)
	private LocalDateTime dateAndTime;
	
	//veza sa apotekom, dodati u pharmcay kada se spoji 
	// apoteka ce imati vise drug deficitquery-ja
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) 
	 private Pharmacy pharmacy;
	 
	
}
