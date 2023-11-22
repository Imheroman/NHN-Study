package networking.quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz09 {
    public static final int port = 1234;
    public static final int bufferSize = 2048;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream socketOut = new BufferedOutputStream(socket.getOutputStream())
        ) {
            byte[] buffer = new byte[bufferSize];
            int length;

            while ((length = socketIn.read(buffer)) > 0) {
                socketOut.write(buffer, 0, length);
                socketOut.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
