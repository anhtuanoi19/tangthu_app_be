package com.example.tangthu_app_be.rest.clients;

import com.example.tangthu_app_be.repo.mongorepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "view/index";
    }
}
