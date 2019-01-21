package com.coinceres.open.openmarket.controller;

import com.coinceres.open.openmarket.pojo.Greeting;
import com.coinceres.open.openmarket.pojo.HelloMessage;
import com.coinceres.open.openmarket.pojo.Ping;
import com.coinceres.open.openmarket.pojo.Pong;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MarketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        // simulated delay
        Thread.sleep(1000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/ping")
    @SendTo("/topic/pong")
    public Pong pong(Ping ping) throws Exception {
        Thread.sleep(1000);
        return new Pong("pong");
    }
}
