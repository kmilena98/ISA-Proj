package ISA.Team54.drugAndRecipe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class DrugSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonManagedReference(value="clinci_movement")
	@ManyToMany
	@JoinTable(name = "contraindicationsInDrugSpecification",joinColumns= @JoinColumn(name = "drugSpecification_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "contraindication_id",referencedColumnName= "id"))
	private List<Contraindication> contraindications = new ArrayList<Contraindication>();
	
	@JsonManagedReference(value="ingredient_clinci_movement")
	@ManyToMany
	@JoinTable(name = "ingredientInDrugSpecification",joinColumns= @JoinColumn(name = "drugSpecification_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName= "id"))	
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();

	
	@Column(unique = false,nullable = false)
	private String suggestedDose;	

	@OneToOne(fetch = FetchType.LAZY)
	private Drug drug;
	
	public DrugSpecification() {
		super();
	}

	
	public DrugSpecification(long id, String suggestedDose) {
		super();
		this.id = id;
		this.suggestedDose = suggestedDose;
	}


	public DrugSpecification(long id, List<Contraindication> contraindications, List<Ingredient> ingredients,
			String suggestedDose) {
		super();
		this.id = id;
		this.contraindications = contraindications;
		this.ingredients = ingredients;
		this.suggestedDose = suggestedDose;
	}


	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<Contraindication> getContraindications() {
		return contraindications;
	}


	public void setContraindications(List<Contraindication> contraindications) {
		this.contraindications = contraindications;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


	public String getSuggestedDose() {
		return suggestedDose;
	}


	public void setSuggestedDose(String suggestedDose) {
		this.suggestedDose = suggestedDose;
	}

}
