package com.example.userservice.dto.impl;

import com.example.userservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
}
