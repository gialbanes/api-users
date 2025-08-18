package com.portfolio.api_users.controller;

import com.portfolio.api_users.business.ProductService;
import com.portfolio.api_users.infrastructure.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct (@RequestBody Product product){
         productService.addProduct(product);
         return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Product> getProduct (@RequestParam Long id){
        productService.findProductById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct (@RequestParam Long id, @RequestBody Product product){
        productService.updateProductById(id, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct (@RequestParam Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Product> getAllProducts (){
        productService.findAll();
        return ResponseEntity.ok().build();
    }
}
