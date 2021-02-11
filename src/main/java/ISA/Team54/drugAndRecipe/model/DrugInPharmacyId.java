package ISA.Team54.drugAndRecipe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DrugInPharmacyId implements Serializable{
	private long pharmaciId;
	private long drugId;
	
	
	public DrugInPharmacyId() {
		super();
	}


	public DrugInPharmacyId(long pharmaciId, long drugId) {
		super();
		this.pharmaciId = pharmaciId;
		this.drugId = drugId;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (drugId ^ (drugId >>> 32));
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
		DrugInPharmacyId other = (DrugInPharmacyId) obj;
		if (drugId != other.drugId)
			return false;
		if (pharmaciId != other.pharmaciId)
			return false;
		return true;
	}
}
