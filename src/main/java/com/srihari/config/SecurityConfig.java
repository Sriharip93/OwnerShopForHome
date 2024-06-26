package com.srihari.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.srihari.filter.JwtFilter;



@Configuration
@EnableWebSecurity  //applies login and makes it mandatory
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dSource;
	
	@Autowired
	JwtFilter jwtFilter;
	
	private static final String[] AUTH_WHITE_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui.html"
            
    };
	
	private static final String[] USER_URLS = {
			
			
		      "/owner/categoryProducts/{category}",
					
					"/owner/getUserById/{id}",
					
			      "/owner/addUser",
			
		
			
            // CHECKING COMMANS
    };
	//fefjaefafaodsf
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		PasswordEncoder pwe=getEncoder();
		auth.inMemoryAuthentication()
		.withUser(User.withUsername("owner1").password(pwe.encode("owner123")).roles("owner"));	
	}
	//gdsghg
	@Bean
	public PasswordEncoder getEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	public void configure(WebSecurity web) throws Exception 
	{
		web.ignoring().antMatchers("/h2-console/**");
		//	.antMatchers("/swagger-ui.html/**"); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeRequests()
	            .antMatchers(AUTH_WHITE_LIST).permitAll() 
	            .antMatchers("/owner/login","/owner/register").permitAll() 
	            .antMatchers(USER_URLS).permitAll()
	            .anyRequest().authenticated()
	            .and()
	            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	

}
