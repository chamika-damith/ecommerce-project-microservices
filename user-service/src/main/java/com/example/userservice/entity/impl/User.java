package com.example.userservice.entity.impl;

import com.example.userservice.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements SuperEntity {
    @Id
    private Long id;
    private String name;
    private String email;
    private String address;
}
