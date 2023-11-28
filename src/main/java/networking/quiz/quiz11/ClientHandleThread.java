package networking.quiz.quiz11;

import java.io.*;
import java.net.Socket;

public final class ClientHandleThread extends Thread {
    private final Socket socket;
    private final networking.quiz.quiz11.Server server;

    public ClientHandleThread(networking.quiz.quiz11.Server server, Socket socket) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try (BufferedReader fromUser = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//             BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            String line;
            while (!(line = fromUser.readLine()).isEmpty()) {
                terminalOut.write(line + '\n');
                terminalOut.flush();
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
