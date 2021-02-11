package ISA.Team54.drugOrdering.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ISA.Team54.drugAndRecipe.model.Drug;

@Entity
public class DrugInOrder {
	
	@EmbeddedId
	private DrugInOrderId id;
	
	@Column(unique = false,nullable = true)
	private int quantity;
	
	
}
