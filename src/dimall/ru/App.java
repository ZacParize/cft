package dimall.ru;

import dimall.ru.implementations.consumers.Consumer;
import dimall.ru.implementations.brokers.InformationBroker;
import dimall.ru.implementations.queues.InformationQueue;
import dimall.ru.implementations.producers.Producer;
import dimall.ru.interfaces.Broker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * демонстрационный модуль
 */
public class App {

    public static void main(String[] args) {

        try
        {
            Broker broker = new InformationBroker(new InformationQueue());
            ExecutorService threadPool = Executors.newCachedThreadPool();
            threadPool.submit(new Producer("Producer1", "1", broker));
            threadPool.submit(new Producer("Producer2", "2", broker));
            threadPool.submit(new Producer("Producer3", "3", broker));
            threadPool.submit(new Producer("Producer4", "4", broker));
            threadPool.submit(new Producer("Producer5", "5", broker));
            threadPool.submit(new Consumer("Consumer1", "1", broker));
            threadPool.submit(new Consumer("Consumer2", "2", broker));
            threadPool.submit(new Consumer("Consumer3", "3", broker));
            threadPool.submit(new Consumer("Consumer4", "4", broker));
            threadPool.submit(new Consumer("Consumer5", "5", broker));
            Thread.sleep(10000);
            broker.setStop(true);
            Thread.sleep(6000);
            threadPool.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
