package security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import domain.AppUser;

//Custom class to load users' details for authentication/authorization purposes
public class UserDetailServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		UserBuilder builder = User.withUsername(user.getUsername());
		//builder.password(user.getPassword()); //no need to encode the password if it is already encoded in the DB
		String encodedPassword = new Pbkdf2PasswordEncoder().encode(user.getPassword());
		builder.password(encodedPassword);
		builder.roles(user.getRole());
		
		return builder.build();
	}

	private AppUser findByUsername(String username) {
		// TODO fetch user from DB
		if (username.equals("user")) {
			return new AppUser("user", "password", "USER");
		} else if (username.equals("admin")) {
			return new AppUser("admin", "password", "ADMIN");
		}
		return null;
	}

}
