package com.example.crud_with_spring_boot.service;

import com.example.crud_with_spring_boot.entity.Product;
import org.springframework.stereotype.Service;
import com.example.crud_with_spring_boot.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // For saving product
    public Product createProduct(Product product){
        try{
            return productRepository.save(product);
        }catch(Exception e){
            throw new RuntimeException("Failed to save product: " + e.getMessage());
        }
    }

    // Get All Products
    public List<Product> getAllProducts(){
        try{
            return productRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Failed to fetch all products: " + e.getMessage());
        }
    }

    // Get Product by ID
    public Optional<Product> getProductById(Long id){
        try{
            return productRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Failed to fetch product by id: " + e.getMessage());
        }
    }

    // Update Product by ID
   public Optional<Product> updateProductById(Long id, Product product){
        try{
            Optional<Product> previousProduct = productRepository.findById(id);
            if(previousProduct.isPresent()){
                Product existingProduct = previousProduct.get();
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setStock(product.getStock());
                Product savedEntity = productRepository.save(existingProduct);
                return Optional.of(savedEntity);
            }else{
                return Optional.empty();
            }
        }catch(Exception e){
            throw new RuntimeException("Failed to update product: " + e.getMessage());
        }
   }

   // Delete Product by ID
    public boolean deleteProductById(Long id){
        try{
            productRepository.deleteById(id);
            return true;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete exception: " + e.getMessage());
        }
    }
}
