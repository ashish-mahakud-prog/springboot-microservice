package com.ANU.productUtility.config;

import com.ANU.productUtility.model.Product;
import com.ANU.productUtility.model.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUtility {

    public static ProductDTO productToDTO(Product product){
        if (product == null) return null;

        return new ProductDTO(product.getProductName(),
                              product.getDescription(),
                              product.getPrice(),
                              product.getQuantity());
    }

    public static Product DTOtoProduct(ProductDTO productDTO){
        if (productDTO == null) return null;
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }

}
