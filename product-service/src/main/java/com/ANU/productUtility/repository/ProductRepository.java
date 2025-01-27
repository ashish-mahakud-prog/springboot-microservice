package com.ANU.productUtility.repository;

import com.ANU.productUtility.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByProductId(Long id);

    void deleteByProductId(Long id);
}
