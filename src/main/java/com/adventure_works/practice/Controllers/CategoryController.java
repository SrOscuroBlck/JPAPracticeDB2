package com.adventure_works.practice.Controllers;

import com.adventure_works.practice.DTO.CategoryDTO;
import com.adventure_works.practice.DTO.ProductDTO;
import com.adventure_works.practice.Models.CategoryModel;
import com.adventure_works.practice.Models.ProductModel;
import com.adventure_works.practice.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryModel>> getCategories() {
        try {
            return ResponseEntity.ok(service.findAllCategories());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable(required = false) Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/v1/{name}")
    public ResponseEntity<CategoryModel> getCategoryByName(@PathVariable(required = false) String name) {
        try {
            return ResponseEntity.ok(service.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
