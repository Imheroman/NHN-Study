package networking.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Quiz04 {
    public static final String host = "localhost";
    public static final int port = 1234;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Socket socket = null;

        try {
            socket = new Socket(host, port);

            while (true) {
                System.out.print("Input >> ");
                sb.append(br.readLine());

                if (sb.toString().equals("exit")) {
                    break;
                }
                sb.append('\n');
                socket.getOutputStream().write(sb.toString().getBytes());

                sb.delete(0, sb.length());
            }
            socket.close();

        } catch (IOException e) {
            System.out.println(host + ":" + port + "에 연결할 수 없읍니다.");
        }

    }
}
