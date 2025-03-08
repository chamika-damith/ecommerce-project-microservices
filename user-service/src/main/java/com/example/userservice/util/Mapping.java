package com.example.userservice.util;


import com.example.userservice.dto.impl.UserDTO;
import com.example.userservice.entity.impl.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    private ModelMapper modelMapper;

    public Mapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //product mapping
    public User toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }

    public UserDTO toUserDTO(User user){
        return modelMapper.map(user,UserDTO.class);
    }

    public List<User> toProductEntityList(List<UserDTO> userDTOS){
        return modelMapper.map(userDTOS,new TypeToken<List<User>>() {}.getType());
    }

    public List<UserDTO> toProductDTOList(List<User> users){
        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }
}
