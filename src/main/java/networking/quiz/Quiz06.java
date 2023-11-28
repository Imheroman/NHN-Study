package networking.quiz;

import java.io.*;
import java.net.Socket;

public class Quiz06 {
    public static final String host = "localhost";
    public static final int port = 1234;

    public static void main(String[] args) {
        String line = "";

        try (Socket socket = new Socket(host, port);
             BufferedReader serverSendBufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // server receives msg from user
             BufferedWriter serverReceiveBufferWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // server input msg to user
             BufferedWriter terminalBW = new BufferedWriter(new OutputStreamWriter(System.out)); // user receives msg from server
             BufferedReader terminalBR = new BufferedReader(new InputStreamReader(System.in)); // user inputs msg to send server
        ) {
            System.out.println("Connection complete on server.");
            System.out.print("User Input >> ");
            while ((line = terminalBR.readLine()) != null) {
                serverReceiveBufferWriter.write(line + "\n");
                serverReceiveBufferWriter.flush();

                line = serverSendBufferReader.readLine();
                terminalBW.write(line + "\n");
                terminalBW.flush();

                System.out.print("User Input >> ");
            }
        } catch (IOException e) {
            System.out.println(host + ":" + port + "에 연결할 수 없읍니다.");
        }
    }
}
