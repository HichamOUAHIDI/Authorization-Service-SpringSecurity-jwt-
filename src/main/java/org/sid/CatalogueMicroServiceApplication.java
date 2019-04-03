package org.sid;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entites.Category;
import org.sid.entites.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueMicroServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CatalogueMicroServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start (CategoryRepository categoryRepository, ProductRepository productRepository){
        return  args->{
            Stream.of("C1 Ordinateur","C2 Imprimantes").forEach(e->{
                categoryRepository.deleteAll();
                categoryRepository.save(new Category(e.split(" ")[0],e.split(" ")[1],new ArrayList<>()));
            });
                categoryRepository.findAll().forEach(System.out::println);

                productRepository.deleteAll();
                Category c1=categoryRepository.findById("C2").get();
                Stream.of("p1","p2","p3").forEach(name->{
                    Product p=productRepository.save(new Product(null,name,Math.random()*1000,c1));
                    c1.getProducts().add(p);
                    categoryRepository.save(c1);
                });
        };
    }
}


