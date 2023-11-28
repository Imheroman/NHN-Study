//package networking.quiz.quiz11;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Server2 {
//    private final ServerSocket serverSocket;
//    private final List<Thread> servers;
//    private Socket socket;
//
//    public Server2(int port) {
//        this.serverSocket = reuseServerOn(port);
//        servers = new ArrayList<>();
//    }
//
//    private ServerSocket reuseServerOn(int port) {
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(port);
//            serverSocket.setReuseAddress(true); // port를 다시 사용할 수 있음
//        } catch (IOException e) {
//            System.err.println("서버에 연결할 수 없읍니다.");
//        }
//
//        return serverSocket;
//    }
//
//    public synchronized void addThreadServer(Thread thread) {
//        try {
//            this.socket = serverSocket.accept();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        thread.start();
//        servers.add(new ThreadServer(thread, socket));
//
//        System.out.println(servers.size() + "명이 입장하였읍니다.");
//    }
//
//    public void terminate() {
//        try {
//            this.serverSocket.close();
//        } catch (IOException e) {
//            System.err.println("서버를 종료할 수 없읍니다.");
//        }
//    }
//
//    public static void main(String[] args) {
//        Server2 server = new Server2(1234);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("This is for loop");
//            server.addThreadServer(new Thread("server" + (i + 1)));
//        }
//    }
//}
