package com.portfolio.api_users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.api_users.DTOs.request.AuthenticationDTO;
import com.portfolio.api_users.DTOs.request.RegisterDTO;
import com.portfolio.api_users.DTOs.response.LoginResponse;
import com.portfolio.api_users.entity.user.User;
import com.portfolio.api_users.repository.UserRepository;
import com.portfolio.api_users.service.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid AuthenticationDTO data) {
        // a classe UsernamePasswordAuthenticationToken vem do spring security; nesse caso, estou juntando o email e senha como uma única variável para ser validado pelo authenticationManager que busca o usuário no UserRepository e compara as senhas
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register (@RequestBody @Valid RegisterDTO data){
        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        // criptografa a senha antes de salvar no banco
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
