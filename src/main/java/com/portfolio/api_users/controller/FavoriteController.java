package com.portfolio.api_users.controller;

import com.portfolio.api_users.entity.Favorite;
import com.portfolio.api_users.service.FavoriteService;

import jdk.javadoc.doclet.Reporter;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<Void> addFavorite (@RequestBody Favorite favorite){
        favoriteService.addFavorite(favorite);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Favorite> getAllFavorite (){
        favoriteService.getAllFavorite();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFavoriteById (@RequestParam Long id){
        favoriteService.deleteFavorite(id);
        return ResponseEntity.ok().build();
    }
}
