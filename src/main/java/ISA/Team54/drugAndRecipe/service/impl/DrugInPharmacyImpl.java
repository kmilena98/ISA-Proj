package ISA.Team54.drugAndRecipe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.repository.DrugsInPharmacyRepository;
import ISA.Team54.drugAndRecipe.service.interfaces.DrugInPharmacyService;

@Service
public class DrugInPharmacyImpl implements DrugInPharmacyService {
	
	@Autowired
	private DrugsInPharmacyRepository repository;

	@Override
	public List<DrugInPharmacy> getDrugsInPharmaciesByDrug(long id) {
		return repository.findByDrugId(id);
	}

}
