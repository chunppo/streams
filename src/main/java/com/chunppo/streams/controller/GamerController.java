package com.chunppo.streams.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/gamer")
public class GamerController {
    static final String topicExchangeName = "topicOrder";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/join")
    public String join(@RequestParam Integer roomId, @RequestParam String nickName) {
        System.out.println("CHUNPPPO1111");
        rabbitTemplate.convertAndSend(topicExchangeName, "queue.gamers", "1");

        return "board";
    }
}
