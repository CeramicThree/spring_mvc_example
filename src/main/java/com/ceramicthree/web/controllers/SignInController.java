package com.ceramicthree.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
    @GetMapping("/in")
    public String signIn(Model model){
        model.addAttribute("title", "Вход");
        return "sign_in";
    }
}
