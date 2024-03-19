package user.service.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import user.service.app.repository.UserRepository;

@Service
public class UserInfo implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password = null;
		List<GrantedAuthority> authorities = null;
		List<user.service.app.model.User> users = userRepository.findByUsername(username);
		
		if(users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("User details not found for the user: " + username);
		} else {
			userName = users.get(0).getUsername();
			password = users.get(0).getPassword();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
		}
		return new User(userName, password, authorities);
	}

}
