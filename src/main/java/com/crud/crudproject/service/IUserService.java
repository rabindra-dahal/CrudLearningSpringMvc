package com.crud.crudproject.service;

import com.crud.crudproject.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    void save(User user) ;
    Optional<User> get(Long id) ;
    void delete(User user) ;


}
