package ISA.Team54.drugOrdering.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DrugInOrderId implements Serializable {
	private long drug_id;
	private long order_id;
	public DrugInOrderId() {
		super();
	}
	public DrugInOrderId(long drug_id, long order_id) {
		super();
		this.drug_id = drug_id;
		this.order_id = order_id;
	}
	public long getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(long drug_id) {
		this.drug_id = drug_id;
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (drug_id ^ (drug_id >>> 32));
		result = prime * result + (int) (order_id ^ (order_id >>> 32));
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
		DrugInOrderId other = (DrugInOrderId) obj;
		if (drug_id != other.drug_id)
			return false;
		if (order_id != other.order_id)
			return false;
		return true;
	}
	
	
}
