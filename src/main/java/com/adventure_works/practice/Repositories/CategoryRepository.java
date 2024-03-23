package com.adventure_works.practice.Repositories;

import com.adventure_works.practice.Models.CategoryModel;
import com.adventure_works.practice.Models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    Optional<CategoryModel> findByName(@Param("name")String name);

}
