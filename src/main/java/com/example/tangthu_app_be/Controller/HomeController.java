package com.example.tangthu_app_be.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class HomeController {
    @GetMapping("home")
    public String home(){
        return "menu";
    }
}
