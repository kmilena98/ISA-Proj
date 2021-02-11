package ISA.Team54.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	Supplier save(Supplier supplier);
	Supplier findByEmail( String email );

}
