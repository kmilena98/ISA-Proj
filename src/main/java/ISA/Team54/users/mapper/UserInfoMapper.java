package ISA.Team54.users.mapper;

import ISA.Team54.users.dto.UserInfoDTO;
import ISA.Team54.users.model.User;

public class UserInfoMapper {
    public UserInfoDTO UserToUserInfoDTO(User user){
        return new UserInfoDTO(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getSurname(),
                user.getAddress(),
                user.getCity(),
                user.getCountry(),
                user.getPhoneNumber()
        );
    }
}
