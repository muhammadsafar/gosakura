package com.mii.sakura.controller;

import com.mii.sakura.model.User;
import com.mii.sakura.repository.UserRepository;
import com.mii.sakura.service.RoleService;
import com.mii.sakura.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private UserRepository ur;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/welcome")
    public String welcome(HttpServletRequest request){
        request.setAttribute("roles", roleService.listRole());
        return "welcome";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping(value = ("/login-user"), method = RequestMethod.POST)
    public String validLogin(@ModelAttribute(name = "dataLogin") User user, Model model){
        
        User dataUser = userService.findByEmail(user.getEmail());
        String mail = dataUser.getEmail();
        String pass = dataUser.getPassword();
        int ide = dataUser.getId();
        
        String takeEmail = user.getEmail();
        String takePassword = user.getPassword();
        
        
        if (mail.equals(takeEmail) && pass.equals(takePassword) && ide == 1) {
            return "user/user";

        }else if (mail.equals(takeEmail) && pass.equals(takePassword) && ide == 6) {
            return "welcome";
        }else {
            model.addAttribute("invalidCredential", true);
            return "login";
        }
    }
}
