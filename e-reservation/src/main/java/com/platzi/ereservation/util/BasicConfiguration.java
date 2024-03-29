/**
 * 
 */
package com.platzi.ereservation.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase para manejar la seguridad
 * @author Juan Pablo
 *
 */
@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter{
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/app/login").permitAll()
		.failureUrl("/app/login?error=true")
		.defaultSuccessUrl("/app/home", true);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("jp_admin").password(encoder.encode("jp")).roles("USER");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");		
	}
}
