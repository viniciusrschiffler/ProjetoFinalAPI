package org.serratec.backend.projetoFinal.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] AUTH_WHITELIST = {
			"/api/enderecoViaCep/{cep}"
	};
	
	private static final String[] USER_PERMISSIONS = {
			"/cliente/listar/{id}",
			"/cliente/atualizar/{id}",
			"/cliente/deletar/{id}",
			
			"/endereco/listar/{id}",
			"/endereco/cadastrar",
			"/endereco/atualizar/{id}",
			"/endereco/deletar/{id}",
			
			"/pedido/listar/{id}",
			"/pedido/cadastrar",
			"/pedido/deletar/{id}",
			
			"/produto/todos",
			"/produto/listar/{id}",
			
			"/itemPedido/listar/{id}",
	};
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http
			.antMatcher("/**").authorizeRequests()
			.antMatchers(AUTH_WHITELIST).permitAll()
			.antMatchers(USER_PERMISSIONS).hasRole("USER")
			.antMatchers("/**/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.inMemoryAuthentication()
				.withUser("user")
				.password("{noop}1234")
				.roles("USER")
				.and()
				.withUser("grupo6")
				.password("{noop}MarceloDa100")
				.roles("USER","ADMIN");
	}
}
