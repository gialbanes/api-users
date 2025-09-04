package com.portfolio.api_users.service;

import com.portfolio.api_users.entity.Rating;
import com.portfolio.api_users.repository.RatingRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository repository;

    public RatingService(RatingRepository repository) {
        this.repository = repository;
    }

    public void add (Rating rating){
        repository.save(rating);
    }

    public Rating getRatingById (Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Avliação não encontrada")
        );
    }

    public List<Rating> getAllRating (){
        return repository.findAll();
    }
}
