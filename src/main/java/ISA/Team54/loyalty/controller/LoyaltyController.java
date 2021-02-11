package ISA.Team54.loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.loyalty.model.LoyaltyCategory;
import ISA.Team54.loyalty.service.LoyaltyService;
 
@RestController
@RequestMapping(value = "/loyalty", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoyaltyController {

	@Autowired
	private LoyaltyService loyaltyService;
	
	@GetMapping("/points")
	public ResponseEntity<LoyaltyCategory> isAvailable(){
		LoyaltyCategory category = loyaltyService.getLoyaltyCategory();
		return new ResponseEntity<LoyaltyCategory>(category, HttpStatus.OK);
	}
}