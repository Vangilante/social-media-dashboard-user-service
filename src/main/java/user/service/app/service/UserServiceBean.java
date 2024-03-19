package user.service.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import user.service.app.model.User;
import user.service.app.repository.UserRepository;

@Service
public class UserServiceBean implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
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
