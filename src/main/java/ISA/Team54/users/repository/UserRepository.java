package ISA.Team54.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ISA.Team54.users.enums.UserRole;
import ISA.Team54.users.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail( String email );
	User findOneById(Long id);
	List<User> findByName(String name);
	List<User> findBySurname(String surname);
	@Query("SELECT u FROM User u WHERE upper(u.name) = ?1 and upper(u.surname) = ?2")
	List<User>findAllByRole(UserRole userRole);
}
