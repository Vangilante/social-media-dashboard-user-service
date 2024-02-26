package user.service.app.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private String username;
	
	private String password;
	
	private String email;
	
	private String bio;
	
	private LocalDate registrationDate;
	
	public static User registerUser( 
								String username,
								String password,
								String email,
								String bio ) {
		LocalDate currentDate = LocalDate.now(); 
		return new User(username, password, email, bio, currentDate);
	}
}
