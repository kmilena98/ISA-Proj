package ISA.Team54.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.model.User;
import ISA.Team54.users.service.interfaces.UserService;



// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	// Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
	// Ukoliko nema, server ce vratiti gresku 403 Forbidden
	// Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
	
	
	@GetMapping("/user/{userId}")
	//@PreAuthorize("hasRole('ADMIN')")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}
	
	@GetMapping("userByName/{name}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<User> loadByName(@PathVariable String name){
		return this.userService.findByName(name);
	}
	
	@GetMapping("/userBySurname/{surname}")
	@PreAuthorize("hasAnyRole('DERMATOLOGIST','PHARMACIST')")
	public List<User> loadBySurname(@PathVariable String name){
		return this.userService.findBySurname(name);
	}
	
	@PutMapping("/user")
	@PreAuthorize("hasAnyRole('PATIENT','SUPPLIER','DERMATOLOGIST','PHARMACIST','PHARMACY_ADMIN','SYSTEM_ADMIN')")
	public void updateUserInfo(@RequestBody UserInfoDTO user){
		this.userService.updateUserInfo(user);
	} 
	/*
	@GetMapping("/user/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Patient> loadAll() {
		return this.userService.findAll();
	}

	@GetMapping("/whoami")
	@PreAuthorize("hasRole('USER')")
	public Patient user(Principal user) {
		return this.userService.findByUsername(user.getName());
	}
	
	@GetMapping("/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }*/
}
