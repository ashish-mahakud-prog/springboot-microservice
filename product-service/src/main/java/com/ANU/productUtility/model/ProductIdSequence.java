package com.ANU.productUtility.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "productIdSequence")
public class ProductIdSequence {

    @Id
    String id;
    Long Sequence;

    @Override
    public String toString() {
        return "ProductIdSequence{" +
                "id='" + id + '\'' +
                ", Sequence=" + Sequence +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductIdSequence that = (ProductIdSequence) o;
        return Objects.equals(id, that.id) && Objects.equals(Sequence, that.Sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Sequence);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSequence() {
        return Sequence;
    }

    public void setSequence(Long sequence) {
        Sequence = sequence;
    }

    public ProductIdSequence() {
    }

    public ProductIdSequence(String id, Long sequence) {
        this.id = id;
        Sequence = sequence;
    }
}
