package com.example.econstudio.data;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;

public class Message {
    private String text = "Default text";
    private Date createdAt = new Date(); // setters & getters

    @GetMapping("/message")
    public Message getMessage() {
        return new Message();
    }
}
