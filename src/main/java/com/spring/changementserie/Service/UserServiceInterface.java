package com.spring.changementserie.Service;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    // LoginMsg loginUser (UserDto login);

    User createUser(User user);
    void deleteUser(Integer id);
    User update(User user , Integer id);
    public Optional<User> getUserById(Integer idUser);

    public List<User> getAllUsers();
}