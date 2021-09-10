package security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//Use a custom user detail service to retrieve user details
		auth.userDetailsService(new UserDetailServiceImpl()).passwordEncoder(new Pbkdf2PasswordEncoder());
		
	}
	
	
	@Override protected void configure(HttpSecurity http) throws Exception {
		http
	      //.csrf().disable() //uncomment if to disable csrf
	      .authorizeRequests()
	      	.antMatchers("/home*").authenticated()
	      	.antMatchers("/admin.jsp").hasRole("ADMIN")
	      	.antMatchers("/user.jsp").hasRole("USER")
	      .and()
	      	.formLogin()
	      	.defaultSuccessUrl("/home", true)
	      .and()
	      	.logout();

	}
	
	
}
