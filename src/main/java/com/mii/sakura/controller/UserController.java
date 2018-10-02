/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.sakura.controller;

import com.mii.sakura.model.Role;
import com.mii.sakura.model.User;
import com.mii.sakura.repository.UserRepository;
import com.mii.sakura.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.util.logging.resources.logging;

/**
 *
 * @author muhammad
 */

@Controller
public class UserController {
   
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserService userService;
    
    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView("user/user");
        List<User> userList = userService.listUser();
        mav.addObject("userList", userList);
        return mav;
    }
    
    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String forAdd(Model model){
        model.addAttribute(new User());
        return "/user/addUser";
    }
    
    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public ModelAndView saveUser(
            @RequestParam("firstname") String firstName,
            @RequestParam("lastname") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("active") Integer active
            ){
        ModelAndView mav = new ModelAndView("redirect:/user-list");
        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setEmail(email);
        user.setPassword(user.getPassword());
        user.setActive(1);
        
        userService.saveUpdate(user);
        return mav;
    }
    
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView("user/view");
        mav.addObject("lists", userService.getUserById(id));
        return mav;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView dodelete(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView("redirect:/user-list");
        userService.deleteUser(id);
        return mav;
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView doUp(@PathVariable("id") int id){
        ModelAndView mav = new ModelAndView("user/edit");
        mav.addObject("lists", userService.getUserById(id));
        return mav;
    }
    
}
