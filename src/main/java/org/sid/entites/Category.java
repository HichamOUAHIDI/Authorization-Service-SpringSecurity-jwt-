package org.sid.entites;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
// dans une base de donnée mongodb  les donnée sont stocké dans des collectoin et une collection un ensemble
// de document ces des donnée equivalan d'un enregistrement mais sous format json
 @Getter
 @Setter
 @AllArgsConstructor
 @NoArgsConstructor
 @ToString
 public class Category {
    @Id
 private String id;
 private String name;
 @DBRef
 //dans un document category j'enrgistre que le id d'un produit
 private Collection<Product> products = new ArrayList<>();
}
