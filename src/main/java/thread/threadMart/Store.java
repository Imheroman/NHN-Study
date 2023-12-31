package thread.threadMart;

/*
매장은 물건을 납품 받아서 판매한다.
매장에는 최대 10개의 물건만 전시할 수 있다.
매장은 최대 5명까지만 동시 입장 가능하다.
매장에서 물건 구매는 동시에 1명만 가능하다.
매장에서 물건 판매 후 빈 공간에 생기면 생산자에게 알려 준다.
매장에서 물건 납품은 동시에 1명만 가능하다.
매장에서 물건이 들어오면 소비자에게 알려 준다.
 */

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Item> items;
    ThreadGroup consumers;

    public Store() { // TODO
        items = new ArrayList<>(10);
        consumers = new ThreadGroup("Consumers");
    }

    public void enter(Thread consumer) { // TODO: 최대 5명까지만 동시 입장 가능
        System.out.println(consumer.getName() + "이 입장하였습니다.");
    }

    public void exit(Consumer consumer) {
        System.out.println(consumer.getName() + "이 퇴장하였습니다.");
        consumer.stop();
    }

    public synchronized void buy(Item item) { // TODO: 판매 후 빈 공간이 생기면 생산자에게 알려준다.
        if (items.size() < 10) {
            items.add(item);
            System.out.println("상점이 물품을 납품받았습니다.");
        }
    }

    public synchronized void sell() { // TODO: 물건을 구매하는 것은 동시에 1명만 가능하다.
        if (items.size() > 0) {
            items.remove(0);
            System.out.println("상점이 물품을 판매하였습니다.");
        }
    }

    public ThreadGroup getConsumers() {
        return consumers;
    }

    public List<Item> getItems() {
        return items;
    }
}
