package com.ANU.productUtility.service;

import com.ANU.productUtility.config.ApplicationUtility;
import com.ANU.productUtility.model.Product;
import com.ANU.productUtility.model.ProductDTO;
import com.ANU.productUtility.model.ProductIdSequence;
import com.ANU.productUtility.repository.ProductIdSequenceRepo;
import com.ANU.productUtility.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final ProductIdSequenceRepo sequenceRepo;

    public Long getSequenceId(){
        ProductIdSequence sequence = sequenceRepo.findAll().stream().toList().get(0);
        if (sequence != null && sequence.getSequence() == 0){
            Long num = sequence.getSequence();
            sequence.setSequence(1L);
            sequenceRepo.save(sequence);
            return 1L;
        }
        Long num = sequence != null ? sequence.getSequence() : 0;
        sequence.setSequence(num+1);
        sequenceRepo.save(sequence);
        return ++num;
    }

    public ProductService(ProductRepository productRepository, ApplicationUtility applicationUtility, ProductIdSequenceRepo sequenceRepo) {
        this.productRepository = productRepository;
        this.sequenceRepo = sequenceRepo;
    }

    public void createProduct(ProductDTO productDTO){
        log.info("Inside create product method ...");
        Product product = ApplicationUtility.DTOtoProduct(productDTO);
        product.setProductId(getSequenceId());
        log.info("Created product is {}",product);
        productRepository.save(product);
    }

    public List<ProductDTO> getProducts() {
         return productRepository.findAll().stream()
                                .map(ApplicationUtility::productToDTO)
                                .toList();
    }

    public Product getProductById(Long id){
        return productRepository.findByProductId(id);
    }

    public String updateProduct(Long id,ProductDTO productDTO){
        if (id == 0 || id == null) return "Invalid id";

        Product product = productRepository.findByProductId(id);
        if (product != null){
            return "Empty data";
        }
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);

        return "Updated "+product;
    }

    public void deleteProductById(Long id){
        log.info("Deleting product with id {}",id);

        productRepository.deleteByProductId(id);

        log.info("Product deleted ...");
    }

}
