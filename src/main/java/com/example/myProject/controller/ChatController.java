package com.example.myProject.controller;

import com.example.myProject.dto.chat.ChatMessage;
import com.example.myProject.dto.chat.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public void enter(ChatMessage message) {
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        messagingTemplate.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
    }
}
