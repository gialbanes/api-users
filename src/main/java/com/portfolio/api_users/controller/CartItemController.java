package com.portfolio.api_users.controller;

import com.portfolio.api_users.entity.CartItem;
import com.portfolio.api_users.service.CartItemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<Void> addCartItem (@RequestBody CartItem cartItem){
        cartItemService.addCartItem(cartItem);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<CartItem> getCartItemById (@RequestParam Long id){
        cartItemService.getCartItemById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCartItem (@RequestParam Long id, @RequestBody CartItem cartItem){
        cartItemService.updateCartItemById(id, cartItem);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCart (@RequestParam Long id){
        cartItemService.deleteCartItemById(id);
        return ResponseEntity.ok().build();
    }
}
