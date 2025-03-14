package com.example.orderservice.entity.impl;

import com.example.orderservice.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements SuperEntity {
    @Id
    private Long id;
    private String customerEmail;
    private int itemId;
    private String orderDate;
    private int amount;
}
