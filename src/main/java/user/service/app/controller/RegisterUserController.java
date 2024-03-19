package user.service.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import user.service.app.model.User;
import user.service.app.repository.UserRepository;

@RestController
public class RegisterUserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User newUser) {
		ResponseEntity response;
		try {
			Optional<List<User>> existingUsers = Optional
													.of(userRepository
															.findByUsername(newUser.getUsername()));
			
			if(existingUsers.isPresent() && !existingUsers.get().isEmpty()) {
				response = ResponseEntity
							.status(HttpStatus.CONFLICT)
							.body("User already exist");
			} else {
				newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
				User savedUser = userRepository.save(newUser);
				response = ResponseEntity
							.status(HttpStatus.CREATED)
							.body("New user registered successfully!");
			}
		} catch (Exception e) {
			response = ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("An Exception occured: " + e.getMessage());
		}
		return response;
	}
}
