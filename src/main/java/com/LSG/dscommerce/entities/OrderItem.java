package com.LSG.dscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Table(name = "tb_order_item")
public class OrderItem {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    @Getter @Setter
    private Integer quantity;
    @Getter @Setter
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Order getOrder(){
        return id.getOrder();
    }
    public Product getProduct(){
        return id.getProduct();
    }
}
