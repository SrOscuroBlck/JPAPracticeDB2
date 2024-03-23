package com.adventure_works.practice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "order_table")
@Entity(name = "Order")
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderModel {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column
    private Long id;

    @Column(
            nullable = false
    )
    private int totalPrice;

    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "order_customer_fk"
            )
    )
    private CustomerModel customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(
            orphanRemoval = true,
            mappedBy = "order",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    @JsonBackReference
    private List<OrderItemModel> orderItems;
}
