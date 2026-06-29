package com.Prasanna.DNExample.service;

import com.Prasanna.DNExample.models.Product;
import com.Prasanna.DNExample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

//    List<Product> products= new ArrayList<>(Arrays.asList(new Product(101,"HairDryer", 500.0),new Product(102,"Lenovo Laptop", 56000.0),new Product(103,"Iphone 11", 30000.0)));

    public List<Product> getProducts(){
    return repo.findAll();
    }

    public Product getProdById(int prodId) {

        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product product) {
        repo.save(product);

    }

    public void updateProducts(Product product) {
        repo.save(product);
    }

    public void deleteProduct(int id) {

        repo.deleteById(id);
        }


    }


