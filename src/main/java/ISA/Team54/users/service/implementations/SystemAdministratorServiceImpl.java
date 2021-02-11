package ISA.Team54.users.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.users.model.SystemAdministrator;
import ISA.Team54.users.repository.SystemAdministratorRepository;
import ISA.Team54.users.service.interfaces.SystemAdministratorService;

@Service
public class SystemAdministratorServiceImpl  implements SystemAdministratorService {
	
	@Autowired
	SystemAdministratorRepository systemAdministratorRepository;
	
	@Override
	public List<SystemAdministrator> findAll() {
		return this.systemAdministratorRepository.findAll();
	}
}

