package com.example.websockettest.controller;


import com.example.websockettest.model.WsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/chat")
//    @SendTo("/topic")
//    @SendToUser()
    public void chatEndpoint(@Payload WsMessage wsMessage){
        System.out.println(wsMessage);
        template.convertAndSend("/topic",wsMessage);
    }
}
