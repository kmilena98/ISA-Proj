package ISA.Team54.users.dto;

public class PharmacyDTO {

	private long id;
	private String name;
	private String address;
	private String city;
	private String country;
	private double rating;
	private double pharmacistPrice;	

	
	public PharmacyDTO() {
		super();
	}
	

	public PharmacyDTO(String name, String address,String city,String country) {
		super();
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	public PharmacyDTO(long id, String name, String address, double rating, double pharmacistPrice) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.pharmacistPrice = pharmacistPrice;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public double getPharmacistPrice() {
		return pharmacistPrice;
	}
	
	public void setPharmacistPrice(double pharmacistPrice) {
		this.pharmacistPrice = pharmacistPrice;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
