package ISA.Team54.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.users.model.SystemAdministrator;

public interface SystemAdministratorRepository extends JpaRepository<SystemAdministrator, Long> {
	SystemAdministrator save(SystemAdministrator systemAdministrator);
	SystemAdministrator findByEmail( String email );

}
