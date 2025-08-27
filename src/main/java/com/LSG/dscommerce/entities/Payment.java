package com.LSG.dscommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
@EqualsAndHashCode
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tb_payment")
@Setter @Getter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    @OneToOne
    @MapsId
    private Order order;
}
