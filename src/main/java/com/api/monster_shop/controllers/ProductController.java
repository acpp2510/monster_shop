package com.api.monster_shop.controllers;

import com.api.monster_shop.models.Product;
import com.api.monster_shop.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getForId(@PathVariable Long id){
        Product product = productService.getProductById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Product don´t found with ID: "+ id));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct (@RequestBody Product newProduct){
        Product createdProduct = productService.saveProduct(newProduct);
        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable Long id, @RequestBody Product productDetails){
        Product existingProduct = productService.getProductById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product not found with ID: " + id));
        Product updatedProduct = productService.updateProduct(existingProduct, productDetails);
        return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product existingProduct = productService.getProductById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product not found with ID: " + id));
        productService.deleteProduct(existingProduct);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
