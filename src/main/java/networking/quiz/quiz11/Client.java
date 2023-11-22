package networking.quiz.quiz11;

import java.io.*;
import java.net.Socket;

import static networking.quiz.quiz11.Server.serverPort;

public final class Client implements Runnable {
    private final Socket socket;
    public static final int bufferSize = 2048;
    private final String name;

    public Client(String name, int port) {
        this.name = name;
        this.socket = initSocket(port);
    }

    private Socket initSocket(int port) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", port);
            System.out.println("Connection completes on server.");
            socket.getOutputStream().write((this.name + "이 입장하였읍니다." + '\n').getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            System.err.println("Client Socket에 연결할 수 없읍니다.");
        }

        return socket;
    }

    @Override
    public void run() {
        try (BufferedInputStream fromServer = new BufferedInputStream(socket.getInputStream());
             BufferedOutputStream toServer = new BufferedOutputStream(socket.getOutputStream());
             BufferedReader terminalIn = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String line;
            StringBuilder sb = new StringBuilder().append(getName() + " >> ");
            int nameLength = getName().length() + " >> ".length();
//            byte[] buffer = new byte[bufferSize];
//            int length = -1;

            while (!(line = terminalIn.readLine()).isEmpty()) {
                sb.append(line).append('\n');
                toServer.write(sb.toString().getBytes());
                toServer.flush();

                sb.delete(nameLength, sb.length());
            }

            line = getName() + "이 퇴장하였읍니다." + '\n';
            toServer.write(line.getBytes());
            toServer.flush();
//            while ((length = fromServer.read(buffer)) > 0) {
//                terminalOut.write(new String(buffer, 0, length) + '\n');
//                terminalOut.flush();
//
//                String line = "From " + this.getName() + " >> " + terminalIn.readLine() + '\n';
//                toServer.write(line.getBytes());
//            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Thread client = new Thread(new Client("Client1", serverPort));
        client.start();
    }
}
