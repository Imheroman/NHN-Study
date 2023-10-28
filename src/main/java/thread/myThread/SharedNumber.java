package thread.myThread;

import java.util.function.UnaryOperator;

public class SharedNumber {
    private int number;

    public SharedNumber() {
        this.number = 0;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }

    public synchronized int getNumber() {
        return number;
    }
}
