package ISA.Team54.vacationAndWorkingTime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.shared.model.DateRange;
import ISA.Team54.vacationAndWorkingTime.service.interfaces.VacationRequestService;

@RestController
@RequestMapping(value = "/vacation", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacationRequestController {
	@Autowired
	private VacationRequestService vacationRequestService;

	@PostMapping("/scheduleVacation")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public ResponseEntity<String> scheduleVacation(@RequestBody DateRange scheduleVacation) {
		try {
			vacationRequestService.scheduleVacation(scheduleVacation);
			return new ResponseEntity<>("Uspesno poslat zahtev!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Zahtev trenutno nije moguce poslati!", HttpStatus.BAD_REQUEST);
		}
	}
}
