package com.adventure_works.practice.Services;

import com.adventure_works.practice.DTO.CategoryDTO;
import com.adventure_works.practice.Models.CategoryModel;
import com.adventure_works.practice.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDTO findById(Long id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Category");
        return categoryDTO;
    }

    public CategoryModel findByName(String name) {
        Optional<CategoryModel> categoryModelOptional = categoryRepository.findByName(name);
        CategoryModel categoryModel = new CategoryModel();
        if(categoryModelOptional.isPresent()) {
            categoryModel = categoryModelOptional.get();
        }
        return categoryModel;
    }

    public List<CategoryModel> findAllCategories() {
        return categoryRepository.findAll();
    }
}
