package ISA.Team54.drugAndRecipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.drugAndRecipe.model.DrugAllergy;

public interface DrugAllergyRepository  extends JpaRepository<DrugAllergy, Long>{
	public List<DrugAllergy> getByPatientId(Long id);
}
