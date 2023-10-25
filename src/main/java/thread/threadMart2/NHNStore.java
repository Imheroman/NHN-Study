package thread.threadMart2;

import java.util.concurrent.Semaphore;

public class NHNStore {
    public static final int CONSUMER_THREADS_NUMBERS = 6;
    public static final int PRODUCER_THREADS_NUMBERS = 4;
    public static final String [] PRODUCT_NAMES = {
            "우유",
            "콜라",
            "사이다",
            "물"
    };

    public static void main(String[] args) throws InterruptedException {
        Store store = new Store(PRODUCER_THREADS_NUMBERS, CONSUMER_THREADS_NUMBERS);

        for (String productName : PRODUCT_NAMES) { // 상인들 생성 및 참여하는 반복문
            Thread producer = new Thread(new Producer(store, productName));
            producer.start();
            store.producerEnter();
            System.out.println("상인 --> " + productName + " 상인이 입장하였습니다.");
        }

        for (int i = 1; i <= CONSUMER_THREADS_NUMBERS; i++) { // 소비자들 생성 및 참여하는 반복문
            if (store.ableToEnterConsumer()) {
                String consumerName = "Consumer_" + i;
                Thread consumer = new Thread(new Consumer(consumerName, store));
                consumer.start();
                store.consumerEnter();
                System.out.println("소비자 --> " + consumerName + "이 입장하였습니다.");
            } else {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException ignore) {
                }
                System.err.println("마트에 인원이 가득찼습니다. 8초간 대기합니다.");
                i--;
            }
        }

        while (true) {
            if (store.getConsumers().availablePermits() == CONSUMER_THREADS_NUMBERS) {
                break;
            }
        }

        System.out.println("영업이 종료됐습니다.");
    }
}