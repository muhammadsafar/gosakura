/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sakura.service;

import com.mii.sakura.model.User;
import com.mii.sakura.repository.UserRepository;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author muhammad
 */
@Service
@Transactional
public class UserService {
    
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }
    
    public User findByEmail(String email){ 
        return userRepository.findByEmail(email);
    }
    
  
    public List<User> listUser() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(int id) { 
        return userRepository.findById(id).get();
    }

    public void saveUpdate(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    
}
