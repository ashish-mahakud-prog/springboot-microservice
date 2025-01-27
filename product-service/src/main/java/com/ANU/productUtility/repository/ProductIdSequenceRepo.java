package com.ANU.productUtility.repository;

import com.ANU.productUtility.model.ProductIdSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductIdSequenceRepo extends MongoRepository<ProductIdSequence, String> {
}
