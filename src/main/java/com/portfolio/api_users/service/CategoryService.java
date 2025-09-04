package com.portfolio.api_users.service;

import com.portfolio.api_users.entity.Category;
import com.portfolio.api_users.entity.Product;
import com.portfolio.api_users.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public void addCategory (Category category){
        repository.save(category);
    }

    public Category getCategoryById (Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria não encontrada")
        );
    }

    public void updateCategoryById (Long id, Category category){
        Category categoryEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria não encontrda")
        );

        List<Product> updatedProducts = category.getProducts() != null ? category.getProducts() : categoryEntity.getProducts();

        for (Product product : updatedProducts) {
            product.setCategory(categoryEntity);
        }

        Category updatedCategory = Category.builder()
                .id(categoryEntity.getId())
                .name(category.getName() != null ? category.getName() : categoryEntity.getName())
                .products(updatedProducts)
                .build();
        repository.save(updatedCategory);
    }

    public void deleteCategoryById (Long id){
        repository.deleteById(id);
    }

    public List<Category> findAllCategory (){
        return repository.findAll();
    }
}
