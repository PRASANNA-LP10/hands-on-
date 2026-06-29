package com.Prasanna.DNExample.controller;


import com.Prasanna.DNExample.models.Product;
import com.Prasanna.DNExample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {



    @Autowired
ProductService productService;



    @GetMapping ("/Products")
    public List<Product> sendProducts(){
        return productService.getProducts();
    }

    @GetMapping ("/Products/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return productService.getProdById(prodId);
    }

    @PostMapping("/Products")
    public void addProducts(@RequestBody Product product){
        System.out.println(product);
        productService.addProduct(product);
    }

    @PutMapping("/Products")
    public void updateProducts(@RequestBody Product product){
        productService.updateProducts(product);
    }

    @DeleteMapping("/Products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

}
