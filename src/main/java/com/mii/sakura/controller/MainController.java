package com.mii.sakura.controller;

import com.mii.sakura.service.RoleService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request){
        request.setAttribute("roles", roleService.listRole());
        return "welcome";
    }
    
    @RequestMapping("/login")
    public String login(){    
        return "login";
    }
}
