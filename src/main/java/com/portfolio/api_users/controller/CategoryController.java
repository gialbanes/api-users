package com.portfolio.api_users.controller;

import com.portfolio.api_users.business.CategoryService;
import com.portfolio.api_users.infrastructure.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Category> getCategory (@RequestParam Long id){
         categoryService.getCategoryById(id);
         return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update (@RequestParam Long id, @RequestBody Category category){
        categoryService.updateCategoryById(id, category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete (@RequestParam Long id){
        categoryService.deleteCategoryById(id);
        return  ResponseEntity.ok().build();
    }

    public ResponseEntity<Category> getAllCategory (){
        categoryService.findAllCategory();
        return ResponseEntity.ok().build();
    }
}
