package ISA.Team54.drugAndRecipe.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.drugAndRecipe.model.DrugInPharmacy;
import ISA.Team54.drugAndRecipe.model.DrugInPharmacyId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsInPharmacyRepository extends JpaRepository<DrugInPharmacy, DrugInPharmacyId>{
	DrugInPharmacy findOneByDrugInPharmacyId(DrugInPharmacyId id);

	@Query("select d from DrugInPharmacy d where drug_id = ?1")
	List<DrugInPharmacy> findByDrugId(long id);
}
