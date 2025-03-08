package com.example.orderservice.dto.impl;

import com.example.orderservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements SuperDTO {
    private Long id;
    private String customerEmail;
    private int itemId;
    private String orderDate;
    private int amount;
}
