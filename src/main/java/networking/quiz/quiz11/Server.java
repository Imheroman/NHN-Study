package networking.quiz.quiz11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final ServerSocket serverSocket;
    private Socket socket;
    private final int bufferSize = 2048;

    public Server(int port) {
        this.serverSocket = reuseServerOn(port);
        System.out.println("The server opens.");
        serverStart();
    }

    private ServerSocket reuseServerOn(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true); // port를 다시 사용할 수 있음
        } catch (IOException e) {
            System.err.println("서버에 연결할 수 없읍니다.");
        }

        return serverSocket;
    }

    private synchronized void serverStart() {
        try {
            this.socket = this.serverSocket.accept();
            BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
            byte[] buffer = new byte[bufferSize];
            int length = -1;

            while ((length = input.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, length));
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
        Server server = new Server(1234);
        server.serverStart();
    }
}
