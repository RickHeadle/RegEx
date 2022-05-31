package regex_new.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import regex_new.dto.UserDto;
import regex_new.entity.User;
import regex_new.repository.UserRepository;
import regex_new.service.UserServiceImpl;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        userService.registerNewUser(userDto);
        return ResponseEntity.ok("");
    }
}
