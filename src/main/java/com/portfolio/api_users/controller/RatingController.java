package com.portfolio.api_users.controller;

import com.portfolio.api_users.entity.Rating;
import com.portfolio.api_users.service.RatingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Void> createRating (@RequestBody Rating rating){
        ratingService.add(rating);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Rating> getRatingById (@RequestParam Long id){
        ratingService.getRatingById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Rating> getAllRating (){
        ratingService.getAllRating();
        return ResponseEntity.ok().build();
    }
}
