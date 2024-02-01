package com.example.product_management.model.service;

import com.example.product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static  List<Product> productList=new ArrayList<>();
    static {
        productList.add(new Product("1","trà sữa","20000","béo","trúc vi"));
        productList.add(new Product("2","trà","10000","thơm","trúc vi"));
        productList.add(new Product("3","cà phê","15000","đậm đà","trúc vi"));
    }
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

}
