package ISA.Team54.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import ISA.Team54.loyalty.model.LoyaltyCategory;

@Repository
public interface LoyaltyRepository extends JpaRepository<LoyaltyCategory, Long>{
	
	@Query("select l from LoyaltyCategory l where lower < ?1 and upper > ?1")
	LoyaltyCategory getLoyaltyCategory(@PathVariable int loyaltyPoints);
}