package com.example.product_management.model.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
     List<Product> findAll();

     void save(Product product);

}
