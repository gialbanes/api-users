package com.portfolio.api_users.business;

import com.portfolio.api_users.infrastructure.entity.Product;
import com.portfolio.api_users.infrastructure.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public Product findProductById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado.")
        );
    }

    public void updateProductById(Long id, Product product){
        Product productEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado.")
        );

        Product updatedProduct = Product.builder()
                .id(productEntity.getId())
                .name(product.getName() != null ? product.getName() : productEntity.getName())
                .description(product.getDescription() != null ? product.getDescription() : productEntity.getDescription())
                .price(product.getPrice() != null ? product.getPrice() : productEntity.getPrice())
                .stock(product.getStock() != null ? product.getStock() : productEntity.getStock())
                .category(product.getCategory() != null ? product.getCategory() : productEntity.getCategory())

                .build();
        repository.save(updatedProduct);
    }

    public void deleteProductById(Long id){
        repository.deleteById(id);
    }

    public List<Product> findAll (){
        return repository.findAll();
    }
}
