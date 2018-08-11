package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.DrawMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * created by yanming on 2018/8/11
 */
@Controller
public class DrawController {

    private final static Logger log = LoggerFactory.getLogger(DrawController.class);

    @MessageMapping("/draw.bunny") // 接收 /app/draw.bunny 的客户端消息
    @SendTo("/topic/bunny")        // 把消息转发给订阅 /topic/bunny的客户端
    public DrawMessage sendMessage(@Payload DrawMessage message) {
        log.info("received message "+message.toString());
        return message;
    }

}
