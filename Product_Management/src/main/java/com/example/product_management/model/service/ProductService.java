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

    @Override
    public Product findById(String id) {
        for (Product product: productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.remove(productList.get(i));
                break;
            }
        }
    }

    @Override
    public void updateProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId().equals(product.getId())){
                productList.get(i).setId(product.getId());
                productList.get(i).setDescribeProduct(product.getDescribeProduct());
                productList.get(i).setNameProduct(product.getNameProduct());
                productList.get(i).setPriceProduct(product.getPriceProduct());
                productList.get(i).setProducer(product.getProducer());
                break;
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products=new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getNameProduct().toLowerCase().contains(name.toLowerCase())){
           products.add(productList.get(i));
//           return products;
            }
        }
        return products;
    }


}
