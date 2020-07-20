package com.ceramicthree.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramsController {
    @GetMapping("/programs")
    public String program(Model model){
        model.addAttribute("title","Программы");
        return "programs";
    }
}
