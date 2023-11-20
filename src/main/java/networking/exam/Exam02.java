package networking.exam;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Exam02 {
    public static final String host = "localhost";
    public static final int port = 8086;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connection complete on server");
            socket.getOutputStream().write("Hello World!\n".getBytes());
            socket.close();
        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }
}
