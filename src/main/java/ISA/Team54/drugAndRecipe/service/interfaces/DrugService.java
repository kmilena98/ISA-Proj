package ISA.Team54.drugAndRecipe.service.interfaces;

import java.util.List;

import ISA.Team54.Examination.model.Examination;
import ISA.Team54.drugAndRecipe.dto.IsAvalableDrugDTO;
import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.model.DrugSpecification;

public interface DrugService {
	public List<Drug> getDrugsForPatient(Long id);
	boolean isDrugAvailable(Long drugId, Examination examination);
	IsAvalableDrugDTO findOrFindSubstitute(long drugId,long examinationId);
	void reduceDrugQuantityInPharmacy(long drugId, int pharmacyId,int quantity);
	DrugSpecification getSpecificationForDrug(Long drugId);
	List<Drug> getAllDrugs();
	Drug findById(long id);
	public List<Drug> getSubstituteForDrug(Long drugId);
}
