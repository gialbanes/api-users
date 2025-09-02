package com.portfolio.api_users.infrastructure.security;

import com.portfolio.api_users.business.TokenService;
import com.portfolio.api_users.infrastructure.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter{ //filtro que acontece uma vez a cada requisição

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        var token = this.recoverToken(request);
        if (token != null){
            var email = tokenService.validateToken(token);
            if (email != null) {
                UserDetails user = userRepository.findByEmail(email);
                if (user != null) {
                    // pego os dados necessários pra fazer a verificação do endpoint
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        // chama o próximo filtro depois que terminar esse; o próximo filtro é o UsernamePasswordAuthenticationFilter
        filterChain.doFilter(request, response);
    }

    // pegando o token do header authorization do insomnia
    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        // remove o campo bearer e deixa só o token mesmo; é o padrão fazer isso
        return authHeader.replace("Bearer ", "");
    }
}