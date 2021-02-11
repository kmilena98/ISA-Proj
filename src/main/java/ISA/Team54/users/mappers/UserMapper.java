package ISA.Team54.users.mappers;

import ISA.Team54.shared.model.DateRange;
import ISA.Team54.users.dto.DermatologistRequestDTO;
import ISA.Team54.users.dto.PharmacistRequestDTO;
import ISA.Team54.users.dto.PharmacyAdministratorRequestDTO;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Dermatologist;
import ISA.Team54.users.model.Pharmacist;
import ISA.Team54.users.model.PharmacyAdministrator;
import ISA.Team54.users.model.User;

public class UserMapper {
	
	public static void UserRequestDTOToUser(UserRequestDTO userRequest,User user) {
		
		user.setEmail(userRequest.getEmail());
		user.setName(userRequest.getFirstName());
		user.setSurname(userRequest.getLastName());
		user.setAddress(userRequest.getAddress());
		user.setCity(userRequest.getCity());
		user.setCountry(userRequest.getCountry());
		user.setPhoneNumber(userRequest.getPhoneNumber());
								
	}
	
	public static Dermatologist  DermatologistRequestDTOToDermatologist(DermatologistRequestDTO dermatologistRequestDTO) {
		Dermatologist dermatologist = new Dermatologist();
		dermatologist.setEmail(dermatologistRequestDTO.getEmail());
		dermatologist.setName(dermatologistRequestDTO.getFirstName());
		dermatologist.setSurname(dermatologistRequestDTO.getLastName());
		dermatologist.setAddress(dermatologistRequestDTO.getAddress());
		dermatologist.setCity(dermatologistRequestDTO.getCity());
		dermatologist.setCountry(dermatologistRequestDTO.getCountry());
		dermatologist.setPhoneNumber(dermatologistRequestDTO.getPhoneNumber());
		dermatologist.setPrice(dermatologistRequestDTO.getPrice());
		return dermatologist;
								
	}
	
	public static Pharmacist  PharmacistRequestDTOToPharmacist(PharmacistRequestDTO pharmacistRequestDTO) {
		Pharmacist pharmacist = new Pharmacist();
		pharmacist.setEmail(pharmacistRequestDTO.getEmail());
		pharmacist.setName(pharmacistRequestDTO.getFirstName());
		pharmacist.setSurname(pharmacistRequestDTO.getLastName());
		pharmacist.setAddress(pharmacistRequestDTO.getAddress());
		pharmacist.setCity(pharmacistRequestDTO.getCity());
		pharmacist.setCountry(pharmacistRequestDTO.getCountry());
		pharmacist.setPhoneNumber(pharmacistRequestDTO.getPhoneNumber());
		pharmacist.setWorkSchedule(new DateRange(pharmacistRequestDTO.getStartDate(), pharmacistRequestDTO.getEndDate()));
		return pharmacist;								
	} 
	
	public static PharmacyAdministrator  PharmacyAdministratorRequestDTOToPharmacist(PharmacyAdministratorRequestDTO pharmacyAdministratorRequestDTO) {
		PharmacyAdministrator pharmacyAdministrator = new PharmacyAdministrator();
		pharmacyAdministrator.setEmail(pharmacyAdministratorRequestDTO.getEmail());
		pharmacyAdministrator.setName(pharmacyAdministratorRequestDTO.getFirstName());
		pharmacyAdministrator.setSurname(pharmacyAdministratorRequestDTO.getLastName());
		pharmacyAdministrator.setAddress(pharmacyAdministratorRequestDTO.getAddress());
		pharmacyAdministrator.setCity(pharmacyAdministratorRequestDTO.getCity());
		pharmacyAdministrator.setCountry(pharmacyAdministratorRequestDTO.getCountry());
		pharmacyAdministrator.setPhoneNumber(pharmacyAdministratorRequestDTO.getPhoneNumber());
		return pharmacyAdministrator;								
	} 
	
}
