package org.example;

import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Objects;

public class ClientInfo {
    private String name;
    private LocalDateTime connectionTime;
    private Socket clientSocket;

    public ClientInfo(String name, LocalDateTime connectionTime, Socket clientSocket) {
        this.name = name;
        this.connectionTime = connectionTime;
        this.clientSocket = clientSocket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(LocalDateTime connectionTime) {
        this.connectionTime = connectionTime;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInfo that = (ClientInfo) o;
        return Objects.equals(name, that.name) && Objects.equals(connectionTime, that.connectionTime) && Objects.equals(clientSocket, that.clientSocket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, connectionTime, clientSocket);
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "name='" + name + '\'' +
                ", connectionTime=" + connectionTime +
                ", clientSocket=" + clientSocket +
                '}';
    }
}
