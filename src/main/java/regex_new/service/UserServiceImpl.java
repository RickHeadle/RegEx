package regex_new.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import regex_new.dto.UserDto;
import regex_new.entity.User;
import regex_new.entity.UserRole;
import regex_new.repository.UserRepository;
import regex_new.repository.UserRoleRepository;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public User registerNewUser(UserDto userDto) {
        //TODO: check to see if User is already exists
        if (isUserNameAlreadyUsed(userDto)) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        User user = new User();
        UserRole userRole = userRoleRepository.findByRoleCode(UserRole.RoleCode.ROLE_USER)
                .orElseThrow(EntityNotFoundException::new);

        user.setUserName(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Set.of(userRole));

        userRepository.save(user);

        return user;
    }

    private boolean isUserNameAlreadyUsed(UserDto userDto) {
        return userRepository.findByUserName(userDto.getUserName()).isPresent();
    }
}
