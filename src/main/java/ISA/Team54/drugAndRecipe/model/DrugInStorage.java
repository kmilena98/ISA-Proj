package ISA.Team54.drugAndRecipe.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ISA.Team54.users.model.Supplier;

@Entity
public class DrugInStorage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = false)
	private int quantity;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Drug drug;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Supplier supplier;	
}
