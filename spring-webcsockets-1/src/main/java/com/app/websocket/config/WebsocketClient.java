package com.app.websocket.config;

import java.io.IOException;
import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;

@ClientEndpoint
public class WebsocketClient {

	@OnOpen
	public void onOpen(Session session) {
		System.err.println("WebSocket connection opened");
        try {
            session.getBasicRemote().sendText("Send me a greeting!");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@OnMessage
    public void onMessage(String message) {
        System.err.println("Received message from server: " + message);
    }
}
