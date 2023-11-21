package networking.quiz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz08 {
    public static final String host = "localhost";
    public static final int port = 1234;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();) {
            System.out.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "가 연결되었읍니다.");
//            System.out.println("Client[" + socket.getLocalAddress() + ":" + socket.getPort() + "]가 연결되었읍니다.");
        } catch (IOException e) {
            System.out.println("Fail");
        }
    }
}
