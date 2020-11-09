package com.chunppo.streams.controller;

import com.chunppo.streams.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LobbyController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/lobby")
    public String lobby(Model model) {
        model.addAttribute("roomList", roomService.getRoomList());

        return "lobby";
    }

}
