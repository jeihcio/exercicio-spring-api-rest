package br.com.alura.forum.config.secutiry;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	// Configuração de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	}

	// Configuração de autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//
				.antMatchers(HttpMethod.GET, "/topicos").permitAll()//
				.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()//
				.anyRequest().authenticated()//
				.and().formLogin();
	}

	// Configuração de recusos (js, css, imagens etc.)
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
