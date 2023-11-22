package networking.quiz.quiz11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final ServerSocket serverSocket;
    public static final int serverPort = 1234;
    private final List<Thread> clientHandlerThreads;

    public Server() {
        this.serverSocket = reuseServerOn();
        this.clientHandlerThreads = new ArrayList<>();
        serverStart();
    }

    private ServerSocket reuseServerOn() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            serverSocket.setReuseAddress(true); // port를 다시 사용할 수 있음
            System.out.println("The server opens.");
        } catch (IOException e) {
            System.err.println("서버에 연결할 수 없읍니다.");
        }

        return serverSocket;
    }

    private void serverStart() {
        try {
            while (true) {
                Socket socket = this.serverSocket.accept();
                Thread clientHandleThread = new networking.quiz.quiz11.ClientHandleThread(this, socket);
                clientHandlerThreads.add(clientHandleThread);
                clientHandleThread.start();

                System.out.println("현재 채팅방 이용자: " + clientHandlerThreads.size() + "명 입니다.");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void terminate() {
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            System.err.println("서버를 종료할 수 없읍니다.");
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.serverStart();
    }
}
