/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sakura.controller;

import com.mii.sakura.model.Role;
import com.mii.sakura.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author muhammad
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/hello")
    public String helloworld(){   
        return "welcome to do";
    }
    
    @GetMapping("/all-roles")
    public String listRole(){
        return roleService.listRole().toString();
    }
    
    @GetMapping("/save-role")
    public String saveRole(@RequestParam int id, @RequestParam String role_name){
        Role role = new Role(id, role_name);
        roleService.save(role);
        return "succes add role";
    }
    
    @GetMapping("/delete-role")
    public String deleteRole(@RequestParam int id){
        roleService.delete(id);
        return "succes delete record";
    }
}
