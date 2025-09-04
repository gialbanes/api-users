package com.portfolio.api_users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Importação correta

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    // a corrente de filtros que eu vou aplicar pra fazer a segurança da minha aplicação; métodos que vão validar o usuário na requisição
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                // tira a tela de login padrão do Spring Security e abre as rotas
                .csrf(csrf -> csrf.disable())
                // autenticação stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // quais são as requisições HTTP que eu vou autorizar
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                        // para usuários 
                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users").hasRole("ADMIN")

                        // para produtos
                        .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/products").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/products").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/products").permitAll()

                        // para itens do carrinho 
                        .requestMatchers(HttpMethod.POST, "/cartItem").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/cartItem").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/cartItem").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PUT, "/cartItem").hasRole("CUSTOMER")

                        // para lista de favoritos
                        .requestMatchers(HttpMethod.POST, "/favorite").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/favorite").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/favorite").hasRole("CUSTOMER")

                        // para avaliação 
                        .requestMatchers(HttpMethod.POST, "/rating").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/rating").permitAll()

                        // para categorias
                        .requestMatchers(HttpMethod.POST, "/category").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/category").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/category").hasRole("ADMIN")

                        // para carrinho 
                        .requestMatchers(HttpMethod.POST, "/cart").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/cart").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PUT, "/cart").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/cart").hasRole("CUSTOMER")

                        // só preciso que esteja autenticado independente da role; para estar autenticado, precisa de um login validado
                        .anyRequest().authenticated()
                )
                // filtro que acontece antes de verificar as requisições do filtro anterior
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    // classe BCryptPasswordEncoder do spring security para criptografar a senha no banco de dados
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}