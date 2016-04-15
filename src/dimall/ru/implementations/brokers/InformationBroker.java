package dimall.ru.implementations.brokers;

import dimall.ru.interfaces.Broker;
import dimall.ru.interfaces.Information;
import dimall.ru.interfaces.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * реализация брокера информационной очереди
 * @param <T> информация
 */
public class InformationBroker<T extends Information> implements Broker<T>{

    /*
     * очередь
     */
    private Queue<T> queue;
    /*
     * флаг состояния брокера
     */
    private AtomicBoolean stop = new AtomicBoolean(false);

    /**
     * конструктор брокера
     * @param queue очередь
     */
    public InformationBroker(Queue<T> queue) {
        this.queue = queue;
    }

    /**
     * получить очередь
     * @return очередь
     */
    private Queue<T> getQueue() {
        return queue;
    }

    /**
     * получить статус брокера
     * @return статус брокера
     */
    @Override
    public boolean isStopped() {
        return this.stop.get();
    }

    /**
     * установить статус брокера
     * @param stop новое состояние брокера
     */
    @Override
    public void setStop(boolean stop) {
        this.stop.compareAndSet(this.isStopped(),stop);
    }

    /**
     * поместить информацию в очередь
     * @param information информация
     */
    @Override
    public synchronized void put(T information) {
        if (information == null) return;
        if (this.getQueue() != null) this.queue.put(information);
    }

    /**
     * получить информацию из очереди
     * @param groupId идентификатор группы
     * @return информация
     */
    @Override
    public synchronized T get(String groupId) {
        if (groupId == null) return null;
        return this.getQueue() == null ? null : this.getQueue().get(groupId);
    }

}
