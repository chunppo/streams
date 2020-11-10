package com.chunppo.streams.controller;

import com.chunppo.streams.model.Gamer;
import com.chunppo.streams.service.GamerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    static final String topicExchangeName = "topicOrder";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private GamerService gamerService;

    @GetMapping("/start")
    public String start() throws JsonProcessingException, InterruptedException {

        for(int i = 5; i > 0; i--) {
            rabbitTemplate.convertAndSend(topicExchangeName, "queue.gamers", String.valueOf(i));
            Thread.sleep(2000);
        }

        return "board";
    }
}
