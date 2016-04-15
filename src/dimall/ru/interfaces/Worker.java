package dimall.ru.interfaces;

/**
 * Поток
 */
public interface Worker {

    /**
     * получить идентификатор группы
     * @return идентификатор группы
     */
    String getGroupId();

    /**
     * получить имя потока
     * @return имя потока
     */
    String getThreadName();

    /**
     * получить брокер
     * @return
     */
    public Broker getBroker();

}