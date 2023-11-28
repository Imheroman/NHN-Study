package networking.exam;

import java.io.IOException;
import java.net.Socket;

public class Exam01 {
    public static final String hostIP = "localhost";
    public static final int port = 12345;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(hostIP, port);
            System.out.println("Connection complete on server");
            socket.close();
        } catch (IOException ignore) {
        }
    }
}
