package networking.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다.");

            // 클라이언트의 입력을 서버로 전송
            OutputStream output = socket.getOutputStream();
            output.write("Hello, Server!".getBytes());

            // 서버로부터의 응답을 받아 출력
            InputStream input = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            while ((bytesRead = input.read(buffer)) > 0) {
                System.out.println("서버 응답: " + new String(buffer, 0, bytesRead));
            }
            // 소켓 닫기
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}