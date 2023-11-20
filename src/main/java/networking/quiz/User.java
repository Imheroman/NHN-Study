package networking.quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public final class User implements Runnable {
    private String name;
    private BufferedWriter bw;
    private Scanner sc = new Scanner(System.in);

    public User(String name, OutputStream out) {
        this.name = name;
        this.bw = new BufferedWriter(new OutputStreamWriter(out));
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + "이 동작합니다.");
        StringBuilder sb = new StringBuilder();
        String line; // User로 부터의 입력

        while (!(line = sc.nextLine()).isEmpty()) {
            sb.append("From User >> ").append(line).append('\n');
            try {
                bw.write(sb.toString()); // Socket을 이용하여 Server에 전달.
                bw.flush();
            } catch (IOException e) {
                System.err.println(e.getStackTrace());
            }

            sb.delete(0, sb.length());
        }
    }
}
