package ISA.Team54.users.service.implementations;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.mappers.UserInfoMapper;
import ISA.Team54.users.model.Patient;
import ISA.Team54.users.model.User;
import ISA.Team54.users.repository.UserRepository;
import ISA.Team54.users.service.interfaces.AuthorityService;
import ISA.Team54.users.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityService authService;

	@Lazy
	@Autowired
	private AuthenticationManager authenticationManager;
	
	protected final Log LOGGER = LogFactory.getLog(getClass());

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByEmail(username);
		return u;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElse(null);
		return u;
	}

	public List<User> findAll() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		return result;
	}
/*	public List<User> findAllByRole() throws AccessDeniedException {
		List<User> result = userRepository.findAll();
		for (User user : result) {
			
		} 
		return result;
	}
	
	public List<User> findAllByRole() throws AccessDeniedException {
		List<User> result = userRepository.findAllByRole(UserRole userRole);
		return result;
	} */

	public List<User> findByName(String name) throws AccessDeniedException {
		List<User> result = userRepository.findByName(name);
		return result;		
	}	
	
	public List<User> findBySurname(String surname) throws AccessDeniedException {
		List<User> result = userRepository.findBySurname(surname);
		return result;		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = userRepository.findByEmail(((User) authentication.getPrincipal()).getEmail());
		
		if (authenticationManager != null) {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(currentUser.getEmail(), oldPassword));
		} else {
			return;
		}
		
		
		currentUser.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(currentUser);
	}

	@Override
	public void updateUserInfo(UserInfoDTO userInfoDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findOneById(((User) authentication.getPrincipal()).getId());
		UserInfoMapper.UserInfoDTOTOUser(userInfoDTO, user);
		userRepository.save(user); 
	}	
	
/*	@Override
	public User save(UserRequestDTO userRequest) {
		User u = new User();
		u.setEmail(userRequest.getUsername());
		// pre nego sto postavimo lozinku u atribut hesiramo je
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		u.setName(userRequest.getFirstname());
		u.setSurname(userRequest.getLastname());
		u.setEnabled(true);
		
		List<Authority> auth = authService.findByname("ROLE_USER");
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		u.setAuthorities(auth);
		
		u = this.userRepository.save(u);
		return u;
	} */


}
