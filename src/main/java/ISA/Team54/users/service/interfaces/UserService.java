package ISA.Team54.users.service.interfaces;

import java.util.List;

import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.model.User;

public interface UserService {
	User findById(Long id);
	User findByUsername(String username);
    List<User> findAll ();
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    void changePassword(String oldPassword, String newPassword);
    void updateUserInfo(UserInfoDTO userInfoDTO);
	

}
