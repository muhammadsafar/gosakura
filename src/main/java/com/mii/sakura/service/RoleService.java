/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sakura.service;

import com.mii.sakura.model.Role;
import com.mii.sakura.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author muhammad
 */
@Service
@Transactional
public class RoleService {
    
    public final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }
    
    /**
     * 
     * @return 
     */
    public List<Role> listRole(){
        List<Role> roles = new ArrayList<>();
        for (Role role : repository.findAll()) {
            roles.add(role);
        }
        return roles;
    }
    
    public void save(Role role){
        repository.save(role);
    }
    
    public void delete(int id){
        repository.deleteById(id);
    }
    
    
}
