package thread.threadMart2;

/*
매장은 물건을 납품 받아서 판매한다.
매장에는 최대 10개의 물건만 전시할 수 있다.
매장은 최대 5명까지만 동시 입장 가능하다.
매장에서 물건 구매는 동시에 1명만 가능하다.
매장에서 물건 판매 후 빈 공간에 생기면 생산자에게 알려 준다.
매장에서 물건 납품은 동시에 1명만 가능하다.
매장에서 물건이 들어오면 소비자에게 알려 준다.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Store {
    private Map<Item, Integer> items;
    private Semaphore producers;
    private Semaphore consumers;
//    ThreadGroup consumers;
//    ThreadGroup producers;

    public Store(int producerNumbers, int consumerNumbers) {
        items = new HashMap<>(producerNumbers);
        consumers = new Semaphore(consumerNumbers);
        producers = new Semaphore(producerNumbers);
    }

//    public void consumerEnter(Thread consumer) {
//        System.out.println("소비자 --> " + consumer.getName() + "이 입장하였습니다.");
//    }
    public void consumerEnter() throws InterruptedException {
        consumers.acquire();
    }

    public void producerEnter() throws InterruptedException {
        producers.acquire();
    }

    public void exit(Consumer consumer) {
        System.out.println(consumer.getName() + "이 퇴장하였습니다.");
        consumer.stop();
    }

    public synchronized void buy(Item item, int itemAmounts) { // 상인에게 물건을 사는 행위
        int oldAmounts = items.get(item);
        items.replace(item, oldAmounts, itemAmounts+oldAmounts);
    }

    public synchronized void sell() { // TODO: 물건을 구매하는 것은 동시에 1명만 가능하다.
        if (items.size() > 0) {
            items.remove(0);
            System.out.println("상점이 물품을 판매하였습니다.");
        }
    }

    public boolean ableToEnterConsumer() {
        return consumers.tryAcquire();
    }

    public Semaphore getProducers() {
        return producers;
    }

    public Semaphore getConsumers() {
        return consumers;
    }
}
