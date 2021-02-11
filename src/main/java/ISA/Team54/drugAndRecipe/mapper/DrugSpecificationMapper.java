package ISA.Team54.drugAndRecipe.mapper;

import java.util.ArrayList;
import java.util.List;

import ISA.Team54.drugAndRecipe.dto.DrugDTO;
import ISA.Team54.drugAndRecipe.dto.DrugSpecificationDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugSpecification;

public class DrugSpecificationMapper {

	public DrugSpecificationDTO DrugSpecificationIntoDrugSpecificationDTO(DrugSpecification drugSpecification,List<Drug> drugSubstitute) {
		List<DrugDTO> substituteDrugsDTO = new ArrayList<DrugDTO>();
		for(Drug d :drugSubstitute ) {
			substituteDrugsDTO.add(new DrugMapper().DrugIntoDrugDTO(d));
		}
		return new DrugSpecificationDTO(drugSpecification.getContraindications(),drugSpecification.getIngredients(),drugSpecification.getSuggestedDose(),substituteDrugsDTO);
	}
}
