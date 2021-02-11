package ISA.Team54.users.mappers;

import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.model.User;

public class UserInfoMapper {
	
	public static UserInfoDTO UserTOUserInfoDTO(User user) {
			return new UserInfoDTO(user.getId(), user.getEmail(), user.getName(), user.getSurname(),
					user.getAddress(), user.getCity(), user.getCountry(), user.getPhoneNumber());
		} 
	
	public static void UserInfoDTOTOUser(UserInfoDTO userInfoDTO,User user) {
		user.setName(userInfoDTO.getName());
		user.setSurname(userInfoDTO.getSurname());
		user.setAddress(userInfoDTO.getAddress());
		user.setCity(userInfoDTO.getCity());
		user.setCountry(userInfoDTO.getCountry());
		user.setPhoneNumber(userInfoDTO.getPhoneNumber());
	}
}
