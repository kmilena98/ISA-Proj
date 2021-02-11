package ISA.Team54.users.service.interfaces;

import java.util.List;

import ISA.Team54.security.Authority;

public interface AuthorityService {
	List<Authority> findById(Long id);
	List<Authority> findByname(String name);
}
