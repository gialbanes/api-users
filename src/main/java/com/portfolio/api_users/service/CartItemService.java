package com.portfolio.api_users.service;

import com.portfolio.api_users.entity.CartItem;
import com.portfolio.api_users.repository.CartItemRepository;
import com.portfolio.api_users.repository.CartRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CartItemService {
    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    public void addCartItem (CartItem cartItem){
        repository.save(cartItem);
    }

    public CartItem getCartItemById (Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Item não encontrado no carrinho.")
        );
    }

    public void updateCartItemById(Long id, CartItem cartItem) {
        CartItem cartItemEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Item do carrinho não encontrado.")
        );

        CartItem updatedItem = CartItem.builder()
                .id(cartItemEntity.getId())
                .cart(cartItem.getCart() != null ? cartItem.getCart() : cartItemEntity.getCart())
                .product(cartItem.getProduct() != null ? cartItem.getProduct() : cartItemEntity.getProduct())
                .quantity(cartItem.getQuantity() != null ? cartItem.getQuantity() : cartItemEntity.getQuantity())
                .build();

        repository.save(updatedItem);
    }

    public void deleteCartItemById (Long id){
        repository.deleteById(id);
    }
}
