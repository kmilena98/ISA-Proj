package ISA.Team54.drugAndRecipe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;


@Embeddable
public class DrugInERecipeId implements Serializable {
	private long pharmaciId;
	private long drugId;
	private long eRecipeId;
	public DrugInERecipeId() {
		super();
	}
	public DrugInERecipeId(long pharmaciId, long drugId, long eRecipeId) {
		super();
		this.pharmaciId = pharmaciId;
		this.drugId = drugId;
		this.eRecipeId = eRecipeId;
	}
	public long getPharmaciId() {
		return pharmaciId;
	}
	public void setPharmaciId(long pharmaciId) {
		this.pharmaciId = pharmaciId;
	}
	public long getDrugId() {
		return drugId;
	}
	public void setDrugId(long drugId) {
		this.drugId = drugId;
	}
	public long geteRecipeId() {
		return eRecipeId;
	}
	public void seteRecipeId(long eRecipeId) {
		this.eRecipeId = eRecipeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (drugId ^ (drugId >>> 32));
		result = prime * result + (int) (eRecipeId ^ (eRecipeId >>> 32));
		result = prime * result + (int) (pharmaciId ^ (pharmaciId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DrugInERecipeId other = (DrugInERecipeId) obj;
		if (drugId != other.drugId)
			return false;
		if (eRecipeId != other.eRecipeId)
			return false;
		if (pharmaciId != other.pharmaciId)
			return false;
		return true;
	}
	
	
}
