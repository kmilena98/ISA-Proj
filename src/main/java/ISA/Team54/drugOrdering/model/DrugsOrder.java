package ISA.Team54.drugOrdering.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import ISA.Team54.drugOrdering.enums.OrderStatus;
import ISA.Team54.users.model.PharmacyAdministrator;

@Entity
@Table(name="orders")
public class DrugsOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date deadline;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Offer> offers;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private PharmacyAdministrator administrator;

	public DrugsOrder() {
		super();
	}

	public DrugsOrder(long id, Date deadline, List<Offer> offers, OrderStatus status,
			PharmacyAdministrator administrator) {
		super();
		this.id = id;
		this.deadline = deadline;
		this.offers = offers;
		this.status = status;
		this.administrator = administrator;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public PharmacyAdministrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(PharmacyAdministrator administrator) {
		this.administrator = administrator;
	}
	
	

}
