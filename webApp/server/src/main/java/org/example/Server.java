package org.example;

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
    private static final String CMD_EXIT = "-exit";
    private static final String CMD_FILE = "-file";
    private static final String FILE_PATH = "src/main/resources";
    private static final Map<String, ClientInfo> ACTIVE_CLIENTS = new HashMap<>();
    private static int clientNum;

    public static void start() {
        LOGGER.info("Server started");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {

                Socket clientSocket = serverSocket.accept();
                var is = new DataInputStream(clientSocket.getInputStream());
                var msg = is.readUTF();

                if (msg.contains(CMD_FILE)) {
                    receiveFile(clientSocket);
                } else if (msg.contains(CMD_EXIT)) {
                    removeClient(clientSocket);
                } else {
                    String clientName = generateName();
                    ACTIVE_CLIENTS.put(clientName, new ClientInfo(clientName, LocalDateTime.now(), clientSocket));
                    sendMessage("[SERVER] %s connected successfully".formatted(clientName));
                    LOGGER.info("Connected new client %s".formatted(clientName));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void removeClient(Socket clientSocket) throws IOException {
        ACTIVE_CLIENTS.remove(getClientName(clientSocket));
        clientSocket.close();
    }

    private static void receiveFile(Socket clientSocket) {
        try {
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            byte[] buffer = new byte[1048576];
            int bytesRead = dis.read(buffer);

            while (bytesRead != -1) {
                writer.write(new String(buffer, 0, bytesRead));
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
}
