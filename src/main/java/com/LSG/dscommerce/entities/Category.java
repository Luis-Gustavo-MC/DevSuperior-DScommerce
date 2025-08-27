package com.LSG.dscommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_category")
public class Category {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @ManyToMany(mappedBy = "categories")
    Set<Product> products = new HashSet<>();
}
