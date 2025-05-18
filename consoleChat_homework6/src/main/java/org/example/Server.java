package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final int PORT = 8080;
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private static final Map<String, ClientHandler> clients = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        logger.info("Server started on port {}", PORT);

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, clients)).start();
            }
        } catch (IOException e){
            logger.error("Error in server socket" ,e);
        }
    }

}
