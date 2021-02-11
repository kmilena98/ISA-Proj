package ISA.Team54.users.service.implementations;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.repository.PharmacyAdministratorRepository;
import ISA.Team54.users.service.interfaces.PharmacyAdministratorService;

@Service
public class PharmacyAdministratorServiceImpl implements PharmacyAdministratorService {

	@Autowired
	private PharmacyAdministratorRepository pharmacyAdministratorRepository;
	
	@Override
	public PharmacyAdministrator findById(Long id) {
		return pharmacyAdministratorRepository.findOneById(id);
	}
	
	@Override
	public List<PharmacyAdministrator> findAll() {
		return this.pharmacyAdministratorRepository.findAll();
	}
}

