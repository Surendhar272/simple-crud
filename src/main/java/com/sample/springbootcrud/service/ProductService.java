package com.sample.springbootcrud.service;

import com.sample.springbootcrud.entity.Product;
import com.sample.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


   //Post one object
    public Product saveProduct(Product product){
      return repository.save(product);
    }

    //Post the list of products
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //get a product form the database
    public  Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //get all the products from the database
    public  List<Product> getProducts(){
        return repository.findAll();
    }

    //get the product using the name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public  String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed ||"+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(product);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

}
