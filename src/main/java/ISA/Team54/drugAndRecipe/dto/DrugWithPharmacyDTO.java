package ISA.Team54.drugAndRecipe.dto;

import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;

public class DrugWithPharmacyDTO {
	
	private String pharmacyName;
	private String pharmacyCity;
	private double pharmacyRating;
	private DrugInPharmacyId drugInPharmacy;
	
	public DrugWithPharmacyDTO() {
		super();
	}
	
	public DrugWithPharmacyDTO(String pharmacyName, String pharmacyCity, double pharmacyRating, DrugInPharmacyId drugInPharmacy) {
		super();
		this.pharmacyName = pharmacyName;
		this.pharmacyCity = pharmacyCity;
		this.pharmacyRating = pharmacyRating;
		this.drugInPharmacy = drugInPharmacy;
	}
	
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getPharmacyCity() {
		return pharmacyCity;
	}
	public void setPharmacyCity(String pharmacyCity) {
		this.pharmacyCity = pharmacyCity;
	}
	public double getPharmacyRating() {
		return pharmacyRating;
	}
	public void setPharmacyRating(double pharmacyRating) {
		this.pharmacyRating = pharmacyRating;
	}
	public DrugInPharmacyId getDrugInPharmacyId() {
		return drugInPharmacy;
	}
	public void setDrugInPharmacyId(DrugInPharmacyId drugInPharmacy) {
		this.drugInPharmacy = drugInPharmacy;
	}
}
