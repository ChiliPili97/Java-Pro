package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());
    private static final String HOST = "localhost";
    private static final int PORT = 8081;
    private static final String CMD_EXIT = "-exit";
    private static final String CMD_FILE = "-file";

    public static void start() {
        try (Socket clientSocket = new Socket(HOST, PORT)) {

            var out = new DataOutputStream(clientSocket.getOutputStream());
            var is = new DataInputStream(clientSocket.getInputStream());

            out.writeUTF(Thread.currentThread().getName());
            LOGGER.info("%s connected to server".formatted(Thread.currentThread().getName()));

            while (true) {

                LOGGER.info("Message from server: %s".formatted(is.readUTF()));

                Scanner scanner = new Scanner(System.in);
                String cmd = scanner.nextLine();

                if (cmd.equals(CMD_EXIT)) {
                    out.writeUTF(cmd);
                    LOGGER.info("Disconnected from server");
                    break;
                } else if (cmd.equals(CMD_FILE)) {
                    sendFile(out, cmd.trim().split(" ")[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendFile (DataOutputStream out, String filePath) {

        File file = new File(filePath);

        try (FileInputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[1048576];
            int bytesRead = is.read(buffer);
            if (bytesRead != -1) {
                out.write(buffer, 0, bytesRead);
            }
            LOGGER.info("File sent to server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        start();
    }
}
