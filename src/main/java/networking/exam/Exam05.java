package networking.exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam05 {
    public static final String host = "localhost";
    public static final int port = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket socket = new Socket(host, port);
            System.out.println("Connection completes on server.");

            socket.getOutputStream().write("Hello!\n".getBytes());
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
