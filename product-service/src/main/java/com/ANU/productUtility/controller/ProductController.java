package com.ANU.productUtility.controller;

import com.ANU.productUtility.model.Product;
import com.ANU.productUtility.model.ProductDTO;
import com.ANU.productUtility.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    List<ProductDTO> getProducts(){
         return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/newProduct")
    void createNewProduct(@RequestBody ProductDTO productDTO){
        log.info("Creating Product {}",productDTO);
        productService.createProduct(productDTO);
    }

    @PutMapping("/Product/{id}")
    void updateProduct(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        log.info("Updating Product {}",productDTO);
        productService.updateProduct(id,productDTO);
    }

    @DeleteMapping("/Product/{id}")
    void deleteProduct(@PathVariable Long id){
        log.info("Deleting {}",id);
        productService.deleteProductById(id);
    }

}
