package com.app.websocket;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.client.WebSocketClient;

import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.WebSocketContainer;

@SpringBootApplication
public class SpringWebcsockets1Application {

	public static void main(String[] args) throws DeploymentException, IOException, URISyntaxException {
		SpringApplication.run(SpringWebcsockets1Application.class, args);
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = new URI("ws://localhost:8080/hello"); // WebSocket server URL

        container.connectToServer(WebSocketClient.class, uri);
	}

}
