package com.chunppo.streams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping
    public String lobby(@RequestParam String id, Model model) {
        model.addAttribute("id", id);
        return "lobby";
    }
}
