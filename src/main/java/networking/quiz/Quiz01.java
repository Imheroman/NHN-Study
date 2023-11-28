package networking.quiz;

import java.io.IOException;
import java.net.Socket;

public class Quiz01 {
    public static final int startScope = 0;
    public static final int endScope = 20000;
    public static final String host = "localhost";
    public static boolean possiblePort = false;

    public static void main(String[] args) {
        for (int port = startScope; port < endScope; port++) {
            try {

                Socket socket = new Socket(host, port);

                System.out.println("port : " + socket.getPort() + "가 열려 있습니다.");
//                possiblePort = socket.isConnected();
//                if (possiblePort) {
//                    System.out.println("port : " + socket.getPort() + "가 열려 있습니다.");
//                }
            } catch (IOException ignore) {

            }
        }
    }
}
