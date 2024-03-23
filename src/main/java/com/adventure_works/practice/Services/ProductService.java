package com.adventure_works.practice.Services;

import com.adventure_works.practice.DTO.ProductDTO;
import com.adventure_works.practice.Models.ProductModel;
import com.adventure_works.practice.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductDTO findById(Long id) {
        Optional<ProductModel> productOptional = productRepository.findById(id);
        ProductModel product = new ProductModel();
        ProductDTO pro = new ProductDTO();
        if(productOptional.isPresent()) {
            product = productOptional.get();
            pro.setName(product.getName());
            pro.setPrice(product.getPrice());
            pro.setOrderItem(product.getOrderItem());
            pro.setText(product.getText());
        }
        return pro;
    }
    public ProductModel findByName(String name) {
        Optional<ProductModel> productOptional = productRepository.findByName(name);
        ProductModel product = new ProductModel();
        if(productOptional.isPresent()) {
            product = productOptional.get();

        }
        return product;
    }

    public List<ProductModel> findAllProducts() {
        return productRepository.findAll();
    }
/*
    public List<Product> findProductsAbovePrice(int price) {
        return productRepository.findProductsAbovePrice(price);
    }

    public void customMethod() {
        Optional<Product> productOptional = productRepository.findProductByName("Test name");
        // TODO
    }
*/
}
