package com.crud.crudproject.service;

import com.crud.crudproject.model.User;
import com.crud.crudproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @ModelAttribute("users")
    @Override
    public List<User> findAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(User user) {
        repo.delete(user);
    }


}
