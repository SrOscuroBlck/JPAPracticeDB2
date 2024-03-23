package com.adventure_works.practice.Controllers;

import java.util.List;

import com.adventure_works.practice.DTO.ProductDTO;
import com.adventure_works.practice.Models.ProductModel;
import com.adventure_works.practice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(required = false) Long id) {
        try {

            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/v1/{name}")
    public ResponseEntity<ProductModel> getProductBtName(@PathVariable(required = false) String name) {
        try {

            return ResponseEntity.ok(service.findByName(name));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getProductList() {
        try {

            return ResponseEntity.ok(service.findAllProducts());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
