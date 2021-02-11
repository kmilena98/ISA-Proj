package ISA.Team54.drugAndRecipe.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="contraindications")
public class Contraindication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false,nullable = true)
	private String name;
	
	@JsonBackReference(value="clinci_movement")
	@ManyToMany(mappedBy = "contraindications")
	private Set<DrugSpecification> drugSpecifications = new HashSet<DrugSpecification>();
	
	public Contraindication() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DrugSpecification> getDrugSpecifications() {
		return drugSpecifications;
	}

	public void setDrugSpecifications(Set<DrugSpecification> drugSpecifications) {
		this.drugSpecifications = drugSpecifications;
	}
	
}
