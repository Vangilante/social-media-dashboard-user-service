package user.service.app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name="user_role")
	private String role;
	
	public User(String username, 
				String password, 
				String email, 
				String bio, 
				String role, 
				LocalDate currentDate) {}
	
	public static User registerUser( 
									String username,
									String password,
									String email,
									String bio,
									String role ) {
		LocalDate currentDate = LocalDate.now(); 
		return new User(username, password, email, bio, role, currentDate);
	}
}
