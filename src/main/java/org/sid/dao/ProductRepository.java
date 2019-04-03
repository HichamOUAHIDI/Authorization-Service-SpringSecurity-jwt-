package org.sid.dao;
import org.sid.entites.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
 public interface ProductRepository extends MongoRepository<Product, String>
 {

 }
