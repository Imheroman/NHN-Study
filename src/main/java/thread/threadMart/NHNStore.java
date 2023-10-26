package thread.threadMart;

public class NHNStore {
    public static final int ENTERANCE_MAX_NUMBERS = 5;
    public static final int CONSUMER_THREADS_NUMBERS = 6;
    public static final int PRODUCER_THREADS_NUMBERS = 5;

    public static void main(String[] args) {
        ThreadGroup consumerThreadGroup;
        ThreadGroup ProducerThreadGroup;
        Store store = new Store();

        Thread producer = new Thread(new Producer(store));
        producer.start();

//        for // Producer threads용 반복문

        for (int i = 1; i <= CONSUMER_THREADS_NUMBERS; i++) {
            consumerThreadGroup = store.getConsumers();

            if (consumerThreadGroup.activeCount() < ENTERANCE_MAX_NUMBERS) {
                String consumerName = "Consumer_" + i;
                Thread consumer = new Thread(consumerThreadGroup, new Consumer(consumerName, store));
                consumer.start();
                store.enter(consumer);
            } else {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ignore) {
                }
                System.err.println("마트에 인원이 가득찼습니다. 4초간 대기합니다.");
                i--;
            }
        }

        while (true) {
            if (store.getConsumers().activeCount() == 0) {
                break;
            }
        }
        producer.stop();
        System.out.println("영업이 종료됐습니다.");
    }
}