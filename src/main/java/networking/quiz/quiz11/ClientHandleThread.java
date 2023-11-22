package networking.quiz.quiz11;

import java.net.Socket;

public final class ClientHandleThread extends Thread {

    public ClientHandleThread(Thread server, Socket socket) {
        System.out.println("This is ClientThread constructor");
    }

    @Override
    public void run() {

    }
}
