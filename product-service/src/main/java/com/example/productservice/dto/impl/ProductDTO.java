package com.example.productservice.dto.impl;

import com.example.productservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements SuperDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
}
