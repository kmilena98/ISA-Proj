package ISA.Team54.drugAndRecipe.mapper;

import ISA.Team54.drugAndRecipe.dto.DrugWithPharmacyDTO;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.users.model.Pharmacy;

public class DrugWithPharmacyMapper {
	
	public DrugWithPharmacyDTO DrugInPharmacyToDrugWithPharmacyDTO(DrugInPharmacy drugInPharmacy, Pharmacy pharmacy) {
		return new DrugWithPharmacyDTO(
				pharmacy.getName(),
				pharmacy.getAddress(),
				pharmacy.getRatings(),
				drugInPharmacy.getDrugInPharmacyId());
	}
}
