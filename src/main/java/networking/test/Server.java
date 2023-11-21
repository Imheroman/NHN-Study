package networking.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private final static int bufferSize = 2048;

    public Server(int port) {
        excuteServer(port);
    }

    private void excuteServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void service() {
        try (Socket socket = this.serverSocket.accept();
             BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String line;

            while (!(line = input.readLine()).isEmpty()) {
                System.out.println("From User >> " + line);
                output.write(line);
                output.flush();
            }


        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void terminate() {
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Server server = new Server(1234);
//        server.service();
//    }

    @Override
    public void run() {
        service();
        terminate();
    }
}
