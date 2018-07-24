package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder().username(env.getProperty("fera.user"))
				.password(env.getProperty("fera.senha")).roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().hasAnyRole("ADMIN").and().authorizeRequests().antMatchers("/**")
				.permitAll().and().formLogin().permitAll().and().csrf().disable();
	}
}
