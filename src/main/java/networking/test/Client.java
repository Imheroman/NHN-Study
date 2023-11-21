package networking.test;

import java.io.*;
import java.net.Socket;


public class Client {
    public static final int port = 1234;
    public static final String host = "localhost";

    public static void main(String[] args) {
        Thread server = new Thread(new Server(port));
        server.run();
        try (Socket client = new Socket(host, port);
             BufferedInputStream input = new BufferedInputStream(client.getInputStream());
             BufferedOutputStream output = new BufferedOutputStream(client.getOutputStream());
             BufferedReader terminalIn = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            System.out.println("Connection completes on server / This is client");

            byte[] buffer = new byte[networking.quiz.Quiz09.bufferSize];
            int length = 0;
//
//
//            while ((length = input.read(buffer)) > 0) {
//                output.write(buffer, 0, length);
//                output.flush();
//            }
            String line;

            System.out.print("Client Input >> ");
            while ((length = input.read(buffer)) > 0) {
                terminalOut.write(length);
                terminalOut.flush();

                line = terminalIn.readLine();
                output.write(line.getBytes());
                output.flush();
                System.out.print("Client Input >> ");
            }

        } catch (IOException e) {
            e.getStackTrace();
        }


    }
}
