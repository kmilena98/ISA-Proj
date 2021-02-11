package ISA.Team54.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.service.interfaces.PharmacistService;

@RestController
@RequestMapping(value = "/pharmacist", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacistController {
	@Autowired
	private PharmacistService dermatologistService;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('PHARMACIST')")
	public Pharmacist loadById(@PathVariable long id){
		return this.dermatologistService.findOneById(id);
	}
}
