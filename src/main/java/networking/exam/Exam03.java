package networking.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Exam03 {
    public static final String host = "localhost";
    public static final int port = 1234;

    public static void main(String[] args) {
        BufferedReader br = null;
        Socket socket = null;
        String line = null;

        try {
            socket = new Socket(host, port);
            System.out.println("Connection complete on server.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            line = br.readLine();

            while (!line.equals("exit")) {
                System.out.print("from server >> ");
                System.out.println(line);
                line = br.readLine();
            }
            socket.close();

        } catch (IOException e) {
            System.out.println(host + ":" + port + "에 연결할 수 없읍니다.");
        }
    }
}
