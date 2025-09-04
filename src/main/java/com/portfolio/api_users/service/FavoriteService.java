package com.portfolio.api_users.service;

import com.portfolio.api_users.entity.Favorite;
import com.portfolio.api_users.repository.FavoriteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    private final FavoriteRepository repository;

    public FavoriteService(FavoriteRepository repository) {
        this.repository = repository;
    }

    public void addFavorite (Favorite favorite){
        repository.save(favorite);
    }

    public List<Favorite> getAllFavorite (){
        return repository.findAll();
    }

    public void deleteFavorite (Long id){
        repository.deleteById(id);
    }
}
