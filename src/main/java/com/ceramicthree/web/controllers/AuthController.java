package com.ceramicthree.web.controllers;

import com.ceramicthree.web.ENUM.Role;
import com.ceramicthree.web.models.Account;
import com.ceramicthree.web.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class AuthController {
    @Autowired
    AccountRepository accountRepo;

    @GetMapping("/auth")
    public String auth(){
        return "/auth";
    }

    @PostMapping("/auth")
    public String addUser(Account account, Model model){
        Account accountDb = accountRepo.findByEmail(account.getEmail());
        if(accountDb != null){
            model.addAttribute("message", "This user already exist");
            return "/auth";
        }
        account.setRoles(Collections.singleton(Role.USER));
        accountRepo.save(account);
        return "redirect:/";
    }

}
