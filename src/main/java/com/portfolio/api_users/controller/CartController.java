package com.portfolio.api_users.controller;

import com.portfolio.api_users.entity.Cart;
import com.portfolio.api_users.entity.Rating;
import com.portfolio.api_users.service.CartService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Void> addCart (@RequestBody Cart cart){
        cartService.addCart(cart);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart (){
        List<Cart> allCarts = cartService.findAllCart();
        return ResponseEntity.ok(allCarts);
    }

    @PutMapping
    public ResponseEntity<Void> updateCart (@RequestParam Long id, @RequestBody Cart cart){
        cartService.updateCartById(id, cart);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCart (@RequestParam Long id){
        cartService.deleteCart(id);
        return ResponseEntity.ok().build();
    }
}
