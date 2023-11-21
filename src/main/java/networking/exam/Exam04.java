package networking.exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam04 {
    public static final String host = "localhost";
    public static final int port = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket socket = new Socket(host, port);
            System.out.println("Connection completes on server.");

            socket.getOutputStream().write("Hello!\n".getBytes());
            socket.getOutputStream().flush();

            socket.close();
//            System.out.println("message from Server >> " + userSocket.getInputStream().read());
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
