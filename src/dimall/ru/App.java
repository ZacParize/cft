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
            //Инициализация приложения
            Broker broker = new InformationBroker(new InformationQueue());
            //не будем себя ограничивать
            ExecutorService threadPool = Executors.newCachedThreadPool();
            final int threadCount = 5;
            //плодим производителей
            for (int idx = 1; idx <= threadCount; idx++) threadPool.execute(new Producer("Producer" + String.valueOf(idx), String.valueOf(idx), broker));
            //плодим потребителей
            for (int idx = 1; idx <= threadCount; idx++) threadPool.execute(new Consumer("Consumer" + String.valueOf(idx), String.valueOf(idx), broker));
            Thread.sleep(10000);
            //завершаем обработчики
            broker.setStop(true);
            Thread.sleep(6000);
            //завершаем пул потоков
            threadPool.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
