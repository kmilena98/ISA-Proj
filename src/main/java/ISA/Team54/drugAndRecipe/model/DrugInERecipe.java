package ISA.Team54.drugAndRecipe.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DrugInERecipe {
	@EmbeddedId
	private DrugInERecipeId id;
	
	@Column(unique = false, nullable = false)
	private int quantityInERecipe;
		
}
