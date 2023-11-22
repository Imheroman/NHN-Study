package networking.quiz;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz10 {
    static final int bufferSize = 2048;
    public static final int port = 1234;

    public static void service(ServerSocket serverSocket) {
        try (Socket socket = serverSocket.accept();
             BufferedInputStream br = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream bw = new BufferedOutputStream(socket.getOutputStream());
        ) {
            byte[] buffer = new byte[bufferSize];
            int len;

            while ((len = br.read(buffer)) > 0) {
                bw.write(buffer, 0, len);
                bw.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!Thread.currentThread().isInterrupted()) {
                Quiz10.service(serverSocket);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
