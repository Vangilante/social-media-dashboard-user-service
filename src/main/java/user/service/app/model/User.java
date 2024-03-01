package user.service.app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	@Column(name="user_id")
	private Long id; 
	
	@Column(name="user_username")
	private String username;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_emailAddress")
	private String email;
	
	@Column(name="user_bio")
	private String bio;
	
	@Column(name="user_registrationDate")
	private LocalDate registrationDate;
	
	public User(String username, 
				String password, 
				String email, 
				String bio, 
				LocalDate currentDate) {}
	
	public static User registerUser( 
									String username,
									String password,
									String email,
									String bio ) {
		LocalDate currentDate = LocalDate.now(); 
		return new User(username, password, email, bio, currentDate);
	}
}
