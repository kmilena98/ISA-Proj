package ISA.Team54.drugAndRecipe.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PharmacyDrugInERecipe {
	@EmbeddedId
	private DrugInERecipeId id;
	
	private int quantity;

	public PharmacyDrugInERecipe() {
		super();
	}

	public PharmacyDrugInERecipe(DrugInERecipeId id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public DrugInERecipeId getId() {
		return id;
	}

	public void setId(DrugInERecipeId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
