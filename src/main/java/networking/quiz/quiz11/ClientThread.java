package networking.quiz.quiz11;

import java.net.Socket;

public final class ClientThread extends Thread {

    public ClientThread(Thread client, Socket socket) {
        System.out.println("This is ClientThread constructor");
    }

    @Override
    public void run() {

    }
}
