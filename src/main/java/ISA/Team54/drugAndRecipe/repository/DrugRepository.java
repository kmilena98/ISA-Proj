package ISA.Team54.drugAndRecipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ISA.Team54.drugAndRecipe.model.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long> {
	public List<Drug> findAll();
	public Drug findOneById(Long id);
	
	public List<Drug> findByNameContainingIgnoreCase(String pattern);
}
