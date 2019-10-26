package br.com.bureau.tracking.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import br.com.bureau.tracking.queue.UserSender;
import br.com.bureau.tracking.security.CustomAuthorization;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserSender userSender;
	
	@Override
    protected void configure(HttpSecurity http) {
		http.addFilterAfter(new CustomAuthorization(this.userSender), BasicAuthenticationFilter.class);
    }

}
