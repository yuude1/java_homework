package org.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    private final Socket socket;
    private final Map<String, ClientHandler> clients;
    private String nickname;
    private PrintWriter out;

    public ClientHandler(Socket socket, Map<String, ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your nickname:");
            nickname = in.readLine();

            while (nickname == null || nickname.trim().isEmpty() || clients.containsKey(nickname)) {
                out.println("Invalid or taken. Try another:");
                nickname = in.readLine();
            }

            clients.put(nickname, this);
            logger.info("User connected: {}", nickname);

            broadcast("User " + nickname + "joined the chat.", nickname);

            String input;
            while ((input = in.readLine()) != null) {
                if (input.equals("/users")) {
                    out.println("Connected users: " + clients.keySet());
                } else if (input.startsWith("/w ")) {
                    String[] parts = input.split(" ",3);
                    if (parts.length < 3) {
                        out.println("Invalid private message format.");
                        continue;
                    }
                    String target = parts[1];
                    String message = parts[2];
                    ClientHandler receiver = clients.get(target);
                    if (receiver != null) {
                        receiver.sendMessage("[Private] " + nickname + ": " + message);
                        logger.info("[PRIVATE] {} -> {}: {}", nickname, target, message);
                    } else {
                        out.println("User not found.");
                    }
                } else {
                    broadcast(nickname + ": " + input, nickname);
                    logger.info("[BROADCAST] {}: {}", nickname, input);
                }
            }
        } catch (IOException e) {
            logger.warn("Connection error with {}",nickname, e);
        } finally {
            try{
                socket.close();
            } catch (IOException e) {
                logger.error("Socket close failed", e);
            }
            clients.remove(nickname);
            broadcast(nickname + "left the chat.", nickname);
            logger.info("User disconnected: {}", nickname);
        }

    }

    private void broadcast(String message, String excludeUser) {
        for (ClientHandler client : clients.values()) {
            if (!client.getNickname().equals(excludeUser)) {
                client.sendMessage(message);
            }
        }
    }
}
