package networking.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int portNumber = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("서버가 포트 " + portNumber + "에서 실행 중...");

            while (true) {
                // 클라이언트가 연결될 때까지 대기
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");

                // 클라이언트 연결을 처리하는 새로운 스레드 생성
                new Thread(new ClientHandler(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // 클라이언트와의 통신을 위한 입출력 스트림 생성
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                // 예시: 간단한 에코 서버
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = input.read(buffer)) != -1) {
                    // 읽은 데이터를 클라이언트에게 다시 전송
                    output.write(buffer, 0, bytesRead);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 클라이언트 소켓 닫기
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}