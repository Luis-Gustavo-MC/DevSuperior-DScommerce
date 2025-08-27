package com.LSG.dscommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Entity
@Table(name = "tb_product")
public class Product {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String name;
    @Setter
    @Column(columnDefinition = "TEXT")
    private String description;
    @Setter
    private Double price;
    @Setter
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories  = new HashSet<>();
    @Getter
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    private List<Order> getOrders(){
        return items.stream().map(OrderItem::getOrder).toList();
    }
}
