package ISA.Team54.users.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.Dermatologist;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {
	Dermatologist findOneById(Long id);
	Dermatologist findByEmail( String email );

}
