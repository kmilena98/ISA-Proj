package ISA.Team54.users.service.interfaces;


import java.util.List;

import ISA.Team54.users.model.PharmacyAdministrator;

public interface PharmacyAdministratorService {
	PharmacyAdministrator findById(Long id);
	List<PharmacyAdministrator> findAll();
}
