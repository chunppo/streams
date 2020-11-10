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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/gamer")
public class GamerController {
    static final String topicExchangeName = "topicOrder";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private GamerService gamerService;

    @GetMapping("/join")
    public String join(@RequestParam Integer roomId, @RequestParam String userIp, @RequestParam String nickName) throws JsonProcessingException {
        gamerService.save(Gamer.builder()
                .userIp(userIp)
                .roomId(roomId)
                .nickName(nickName)
                .build());

        List<Gamer> byRoomId = gamerService.findByRoomId(roomId);
        System.out.println(byRoomId);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(byRoomId);
        rabbitTemplate.convertAndSend(topicExchangeName, "queue.gamers", s);

        return "board";
    }
}
