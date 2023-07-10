package ua.hillel;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileManager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getName());
    private String currentDirectory;

    public FileManager() {
        this.currentDirectory = "/";
    }

    public void start() {
        while (true) {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String rawCommand;
            try {
                rawCommand = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Command command = parseCommand(rawCommand);

            if (command != null) {
                switch (command) {
                    case CD -> changeDirectory(rawCommand);
                    case LS -> listDirectory();
                    case CP -> copyFiles(rawCommand);
                    case PWD -> printWorkDirectory();
                }
            }
        }
    }

    private Command parseCommand(String commandRaw) {
        try {
            if (commandRaw.contains(" ")) {
                String subCommand = commandRaw.split(" ")[0];
                return Enum.valueOf(Command.class, subCommand.toUpperCase());
            } else {
                return Enum.valueOf(Command.class, commandRaw.toUpperCase());
            }

        } catch (Exception ignore) {
        }
        return null;
    }

    private void changeDirectory(String command) {
        try {
            String subCommand = command.split(" ")[1];
            if (subCommand.equals("..")) {
                int lastIndex = currentDirectory.lastIndexOf("/");
                if (lastIndex != -1) {
                    currentDirectory = currentDirectory.substring(0, lastIndex);
                }
            } else {
                currentDirectory = subCommand;
            }
        } catch (Exception ignore) {
        }
        LOGGER.info(currentDirectory);
    }

    private void listDirectory() {
        try {
            File file = new File(currentDirectory);
            StringBuilder sb = new StringBuilder();

            for (File f : file.listFiles()) {
                sb.append(f.getName() + "\n");
            }
            LOGGER.info(sb.toString());
        } catch (Exception e) {
            LOGGER.info("Set correct path by using - cd");
        }

    }

    private void copyFiles(String command) {
        String source = command.split(" ")[1];
        String target = command.split(" ")[2];
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(source));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(target));

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
            LOGGER.info("Copy success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printWorkDirectory() {
        LOGGER.info(currentDirectory);
    }

}
