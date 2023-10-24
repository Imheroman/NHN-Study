package thread.threadMart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
생산자는 매장에 물건이 부족하지 않도록 채움
물건은 1~10초 간격으로 채움
Thread내에서 난수 생성을 위해서는 ThreadLocalRandom.current().nextInt()를 사용
 */

public class Producer implements Runnable {
    private List<Item> items;
    private Store store;
    private int interval = 0;
    public static final int INTERVAL_TIMES = 1000;
    public static final int ITEMS_SIZE = 100;

    public Producer(Store store) {
        this.store = store;
        this.items = new ArrayList<>(ITEMS_SIZE);
    }

    private void produce() {
        Item item = new Item();
        items.add(item);
    }

    private void sellItem() {
        if (store.getItems().size() <= 10) {
            Item item = this.items.get(0);
            store.buy(item);
            this.items.remove(0);
        }
    }

    public void stop() {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        int size = 0;
        while (ITEMS_SIZE > size) {
            interval = ThreadLocalRandom.current().nextInt(INTERVAL_TIMES, INTERVAL_TIMES * 10);
            try {
                this.produce();
                this.sellItem();
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            size++;
        }
    }
}
