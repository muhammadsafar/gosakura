/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sakura.repository;

import com.mii.sakura.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author muhammad
 */
//@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    public User findByEmail(String email);
}
