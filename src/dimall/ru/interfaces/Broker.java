package dimall.ru.interfaces;

/**
 * интерфейс брокера информационной очереди
 * @param <T> информация
 */
public interface Broker<T extends Information> {

    /**
     * получить статус брокера
     * @return
     */
    public boolean isStopped();

    /**
     * поменять статус брокера
     * @param stop
     */
    public void setStop(boolean stop);

    /**
     * поместить информацию в очередь
     * @param information
     */
    public void put(T information);

    /**
     * получить информацию из очереди
     * @param groupId
     * @return
     */
    public T get(String groupId);

}
