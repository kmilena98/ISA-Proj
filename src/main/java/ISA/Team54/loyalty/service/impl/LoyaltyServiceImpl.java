package ISA.Team54.loyalty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ISA.Team54.loyalty.model.LoyaltyCategory;
import ISA.Team54.loyalty.repository.LoyaltyRepository;
import ISA.Team54.loyalty.service.LoyaltyService;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.repository.PatientRepository;

@Service
public class LoyaltyServiceImpl implements LoyaltyService {
	
	@Autowired
	private LoyaltyRepository loyaltyRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public LoyaltyCategory getLoyaltyCategory() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientRepository.findById(((Patient) authentication.getPrincipal()).getId());		
		return loyaltyRepository.getLoyaltyCategory(patient.getLoyaltyPoints());
	}

	
}