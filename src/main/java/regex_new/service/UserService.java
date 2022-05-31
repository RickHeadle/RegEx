package regex_new.service;

import regex_new.dto.UserDto;
import regex_new.entity.User;

public interface UserService {

    User registerNewUser(UserDto userDto);
}
