package com.example.userservice.service;

import java.util.List;

public interface CRUDUtil <T>{
    void save(T dto);
    void delete(Long id);
    void update(Long id, T dto);
    T get(Long id);
    List<T> getAll();
}
