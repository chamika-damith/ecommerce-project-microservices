package com.example.userservice.service.impl;

import com.example.userservice.dao.UserDao;
import com.example.userservice.dto.impl.UserDTO;
import com.example.userservice.entity.impl.User;
import com.example.userservice.service.UserService;
import com.example.userservice.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final Mapping userMapper;

    public UserServiceImpl(UserDao userDao, Mapping userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public void save(UserDTO dto) {
        User userEntity = userMapper.toUserEntity(dto);
        userDao.save(userEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<User> byId = userDao.findById(id);
        if (byId.isPresent()){
            userDao.deleteById(id);
        }
    }

    @Override
    public void update(Long id, UserDTO dto) {
        Optional<User> byId = userDao.findById(id);
        if(byId.isPresent()) {
            User user = byId.get();

            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setAddress(dto.getAddress());

            userDao.save(user);
        }
    }

    @Override
    public UserDTO get(Long id) {
        if(userDao.existsById(id)){
            User referenceById = userDao.getReferenceById(id);

            return userMapper.toUserDTO(referenceById);
        }
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toProductDTOList(userDao.findAll());
    }
}
