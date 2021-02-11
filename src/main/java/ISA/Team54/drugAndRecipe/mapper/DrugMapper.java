package ISA.Team54.drugAndRecipe.mapper;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.model.Drug;

public class DrugMapper {

	public DrugDTO DrugIntoDrugDTO(Drug drug)
	{
		return new DrugDTO(drug.getId(),drug.getCode(),drug.getLoyalityPoints(),drug.getName());
	}
	
}
