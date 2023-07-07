package org.example;

import org.example.commands.Commands;
import org.springframework.expression.ExpressionInvocationTargetException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    public static final int PORT = 8081;
    private static final String FILE_PATH = "src/main/resources";
    private static final Map<String, ClientInfo> ACTIVE_CLIENTS = new HashMap<>();
    private static int clientNum;

    public static void start() {
        LOGGER.info("Server started");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {

                Socket clientSocket = serverSocket.accept();
                if (!isClientExist(clientSocket)) {
                    addNewClient(clientSocket);
                }

                var is = new DataInputStream(clientSocket.getInputStream());
                var msg = is.readUTF();

                try {
                    Commands command = Enum.valueOf(Commands.class, msg.split(" ")[0]);
                    switch (command) {
                        case EXIT -> removeClient(clientSocket);
                        case FILE -> receiveFile(clientSocket);
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void removeClient(Socket clientSocket) throws IOException {
        ACTIVE_CLIENTS.remove(getClientName(clientSocket));
        clientSocket.close();
        LOGGER.info("%s disconnected from server".formatted(getClientName(clientSocket)));
    }

    private static void receiveFile(Socket clientSocket) {
        try {
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            byte[] buffer = new byte[1048576];
            int bytesRead = dis.read(buffer);

            while (bytesRead != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < bytesRead; i++) {
                    stringBuilder.append((char) buffer[i]);
                }
                writer.write(stringBuilder.toString());
            }
            writer.close();

            LOGGER.info("File received from " + getClientName(clientSocket));
            sendMessage("[SERVER] File received from " + getClientName(clientSocket));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateName() {
        clientNum++;
        return "Client-%d".formatted(clientNum);
    }

    private static void sendMessage(String message) {
        ACTIVE_CLIENTS.values().forEach(clientInfo -> {
            try {
                var out = new DataOutputStream(clientInfo.getClientSocket().getOutputStream());
                out.writeUTF(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static String getClientName(Socket socket) {
        for (ClientInfo clientInfo : ACTIVE_CLIENTS.values()) {
            if (clientInfo.getClientSocket() == socket) {
                return clientInfo.getName();
            }
        }
        return null;
    }

    private static boolean isClientExist(Socket socket) {
        for (ClientInfo clientInfo : ACTIVE_CLIENTS.values()) {
            if (clientInfo.getClientSocket() == socket) {
                return true;
            }
        }
        return false;
    }

    private static void addNewClient(Socket clientSocket) {
        String clientName = generateName();
        ACTIVE_CLIENTS.put(clientName, new ClientInfo(clientName, LocalDateTime.now(), clientSocket));
        sendMessage("[SERVER] %s connected successfully".formatted(clientName));
        LOGGER.info("Connected new client: %s".formatted(clientName));
    }
}
