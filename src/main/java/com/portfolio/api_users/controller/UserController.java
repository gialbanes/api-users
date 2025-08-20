package com.portfolio.api_users.controller;

import com.portfolio.api_users.business.UserService;
import com.portfolio.api_users.infrastructure.entity.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getUserById(@RequestParam Long id) {
        try {
            User user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @PutMapping
    public ResponseEntity<Void> updateUser (@RequestParam Long id, @RequestBody User user){
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserById (@RequestParam Long id){
        userService.deleteUser(id);
        return  ResponseEntity.ok().build();
    }
}
