package com.ceramicthree.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    @GetMapping("/up")
    public String signIn(Model model){
        model.addAttribute("title", "Регистрация");
        return "sign_up";
    }
}

