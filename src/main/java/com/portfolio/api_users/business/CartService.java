package com.portfolio.api_users.business;

import com.portfolio.api_users.infrastructure.entity.Cart;
import com.portfolio.api_users.infrastructure.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public void addCart (Cart cart){
        repository.save(cart);
    }

    public List<Cart> findAllCart (){
        return repository.findAll();
    }

    public void updateCartById(Long id, Cart cart) {
        Cart cartEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Carrinho não encontrado.")
        );

        Cart updatedCart = Cart.builder()
                .id(cartEntity.getId())
                .user(cart.getUser() != null ? cart.getUser() : cartEntity.getUser())
                .items(cart.getItems() != null ? cart.getItems() : cartEntity.getItems())
                .build();

        repository.save(updatedCart);
    }

    public void deleteCart (Long id){
        repository.deleteById(id);
    }
}
