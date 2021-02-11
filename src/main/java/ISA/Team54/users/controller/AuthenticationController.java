package ISA.Team54.users.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ISA.Team54.exceptions.ResourceConflictException;
import ISA.Team54.security.Authority;
import ISA.Team54.security.TokenUtils;
import ISA.Team54.security.UserTokenState;
import ISA.Team54.security.auth.JwtAuthenticationRequestDTO;
import ISA.Team54.users.dto.DermatologistRequestDTO;
import ISA.Team54.users.dto.PharmacyAdministratorRequestDTO;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.enums.UserRole;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.implementations.CustomUserDetailsService;
import ISA.Team54.users.service.interfaces.PharmacyService;
import ISA.Team54.users.service.interfaces.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	protected final Log LOGGER = LogFactory.getLog(getClass());

	
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PharmacyService pharmacyService;

	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequestDTO authenticationRequest,
			HttpServletResponse response) {

		// 
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();


		UserRole userRole = null;		
		
		if(authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_PATIENT"))) {
			userRole = UserRole.ROLE_PATIENT;
		} else if (authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_SUPPLIER"))) {
			userRole = UserRole.ROLE_SUPPLIER;
		} else if (authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_PHARMACY_ADMIN"))) {
			userRole = UserRole.ROLE_PHARMACY_ADMIN;
		} else if (authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_SYSTEM_ADMIN"))) {
			userRole = UserRole.ROLE_SYSTEM_ADMIN;
		} else if (authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_DERMATOLOGIST"))) {
			userRole = UserRole.ROLE_DERMATOLOGIST;
		} else if (authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_PHARMACIST"))) {
			userRole = UserRole.ROLE_PHARMACIST;
		}
		
	
		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, user.getId(), userRole));
	}

	// Endpoint za registraciju novog korisnika
	
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRequestDTO userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getEmail());
		if (existUser != null) {
			throw new ResourceConflictException((long)0, "Username already exists");
		}
		
		User user = this.pharmacyService.addPatient(userRequest);;			
	
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri()); 
		return new ResponseEntity<>(user, HttpStatus.CREATED); 
	} 
	
	@PostMapping("/signupSupplierOrSystemAdmin")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public ResponseEntity<User> addSupplierOrSystemAdmin(@RequestBody UserRequestDTO userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getEmail());
		if (existUser != null) {
			throw new ResourceConflictException((long)0, "Username already exists");
		}
		User user = null;
		switch(userRequest.getRole()) {
			case ROLE_SUPPLIER:
				user = this.pharmacyService.addSupplier(userRequest);
				break;
			case ROLE_SYSTEM_ADMIN:
				user = this.pharmacyService.addSystemAdministrator(userRequest);	
				break;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri()); 
		return new ResponseEntity<>(user, HttpStatus.CREATED); 
	} 
	
	@PostMapping("/signupPharmacyAdmin")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public ResponseEntity<User> addPharmacyAdmin(@RequestBody PharmacyAdministratorRequestDTO pharmacyAdministratorRequestDTO, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(pharmacyAdministratorRequestDTO.getEmail());
		if (existUser != null) {
			throw new ResourceConflictException((long)0, "Username already exists");
		}
		
		User user = this.pharmacyService.addPharmacyAdministrator(pharmacyAdministratorRequestDTO);	
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri()); 
		return new ResponseEntity<>(user, HttpStatus.CREATED); 
	} 


	@PostMapping("/signupDermatologist")
	@PreAuthorize("hasRole('SYSTEM_ADMIN')")
	public ResponseEntity<User> addDermatologist(@RequestBody DermatologistRequestDTO dermatologistRequestDTO, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(dermatologistRequestDTO.getEmail());
		if (existUser != null) {
			throw new ResourceConflictException((long)0, "Username already exists");
		}
		
		User user = this.pharmacyService.addDermatologist(dermatologistRequestDTO);	
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{userId}").buildAndExpand(user.getId()).toUri()); 
		return new ResponseEntity<>(user, HttpStatus.CREATED); 
	} 

	
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasAnyRole('PATIENT','SUPPLIER','DERMATOLOGIST','PHARMACIST','PHARMACY_ADMIN','SYSTEM_ADMIN')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);

		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.ok().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}
