package com.adventure_works.practice.Models;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "product_category")
@Entity(name = "ProductCategory")
@Getter
public class ProductCategoryModel {
    @EmbeddedId
    private ProductCategoryId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(
            name = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_category_product_id_fk"
            )
    )
    private ProductModel product;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(
            name = "category_id",
            foreignKey = @ForeignKey(
                    name = "product_category_category_id_fk"
            )
    )
    private CategoryModel category;
}
