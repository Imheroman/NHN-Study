package networking.quiz;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Quiz03 {
    public static final int port = 8086;
    public static final String host = "localhost";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connection complete on server.");
            System.out.println("Local address: " + socket.getLocalAddress());
            System.out.println("Local port: " + socket.getLocalPort());
            System.out.println("Remote address: " + socket.getInetAddress().getHostAddress());
            System.out.println("Remote port: " + socket.getPort());

            socket.close();
        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없읍니다.");
        } catch (IOException e) {
            System.err.println(port + "에 연결할 수 없읍니다.");
        }
    }
}
