package user.service.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfile {

	@GetMapping("/user-profile")
	public String getUserProfile() {
		return "this is the user profile page";
	}
}
