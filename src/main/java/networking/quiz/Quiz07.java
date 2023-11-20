package networking.quiz;

import java.io.*;
import java.net.Socket;

public class Quiz07 {
    public static final String host = "localhost";
    public static final int port = 1234;

    public static void main(String[] args) {

        try (Socket serverSocket = new Socket(host, port)) {
            Thread user = new Thread(new User("user", serverSocket.getOutputStream()));
            user.start();

            // Server로부터 전달되는 message를 전달할 BufferedReader
            BufferedReader msgFromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            String line; // Server가 전달하는 message
            while (!(line = msgFromServer.readLine()).isEmpty()) {
                System.out.println("From Server >> " + line);
            }

        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }
}
