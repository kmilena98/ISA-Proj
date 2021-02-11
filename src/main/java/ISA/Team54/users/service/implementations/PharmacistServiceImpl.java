package ISA.Team54.users.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.repository.PharmacistRepository;
import ISA.Team54.users.service.interfaces.PharmacistService;

@Service
public class PharmacistServiceImpl implements PharmacistService {

	@Autowired
	private PharmacistRepository pharmacistRepository;
	public Pharmacist findOneById(long id) {
		return pharmacistRepository.findOneById(id);
	}
}
