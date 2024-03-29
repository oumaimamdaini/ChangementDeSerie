package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Dto.UserDto;
import com.spring.changementserie.Models.User;
import com.spring.changementserie.Repository.UserRepository;
import com.spring.changementserie.Service.UserServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class UserImplService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }
    public User getUser(Integer id){
        return  userRepo.findById(id).get();
    }
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }


    public User update(User updatedUser, Integer id) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            if (updatedUser.getFirstName() != null) {
                existingUser.setFirstName(updatedUser.getFirstName());
            }
            if (updatedUser.getLastName() != null) {
                existingUser.setLastName(updatedUser.getLastName());
            }

            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getProfil() != null) {
                existingUser.setProfil(updatedUser.getProfil());
            }

            return userRepo.save(existingUser);
        }

        return null;
    }

    @Override
    public Optional<User> getUserById(Integer idUser) {

        return userRepo.findById(idUser);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepo.findAll();
    }



/*@Override
    public LoginMsg loginUser(UserDto login) {
        String msg = "";
        User user1 = userRepo.findByEmail(login.getEmailDto());
        if (user1 != null) {
            String password = login.getPasswordDto();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findByEmailAndPassword(login.getEmailDto(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMsg("Login Success", true);
                } else {
                    return new LoginMsg("Login Failed", false);
                }
            } else {
                return new LoginMsg("password Not Match", false);
            }
        }else {
            return new LoginMsg("Email not exits", false);
        }
    }*/


}


