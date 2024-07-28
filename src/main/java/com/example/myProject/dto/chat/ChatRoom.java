package com.example.myProject.dto.chat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatRoom {

    private String roomId;
    private String roomName;

    public static ChatRoom createRoom(String roomId, String roomName) {
        return ChatRoom.builder()
                .roomId(roomId)
                .roomName(roomName)
                .build();
    }
}
