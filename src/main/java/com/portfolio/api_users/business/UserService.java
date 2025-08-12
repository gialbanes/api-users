package com.portfolio.api_users.business;

import com.portfolio.api_users.infrastructure.entity.User;
import com.portfolio.api_users.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser (User user){
        repository.save(user);
    }

    public User findUserById (Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );
    }

    public void updateUser (Long id, User user){
        User userEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado.")
        );

        User updatedUser = User.builder()
                .id(userEntity.getId())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .password(user.getPassword() != null ? user.getPassword() : userEntity.getPassword())
                .build();
        repository.save(updatedUser);
    }

    public void deleteUser (Long id){
        repository.deleteById(id);
    }
}
