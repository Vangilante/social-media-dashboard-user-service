package user.service.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import user.service.app.model.User;

public interface UserService {
	
	public ResponseEntity<String> registerUser(@RequestBody User newUser);
	
}
