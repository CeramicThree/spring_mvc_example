package com.ceramicthree.web.controllers;

import com.ceramicthree.web.models.Account;
import com.ceramicthree.web.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class AuthController {
    @Autowired
    AccountRepository accountRepo;

    @GetMapping("/auth")
    public String auth() {
        return "/auth";
    }

    @PostMapping("/auth")
    public String signUp(@RequestParam String email, @RequestParam String password){
        Optional<Account> account = accountRepo.findByEmail(email);
        if (account.isPresent()) {
            accountRepo.save(new Account(email, password));
        } else {
            System.out.println("User with this email is exist");
        }
        return "redirect:/";
    }
}
