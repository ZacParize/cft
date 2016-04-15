package dimall.ru.implementations.queues;

import dimall.ru.interfaces.Information;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Реализация очереди (см. readme.txt)
 * @param <T> элемент
 */
public class InformationQueue<T extends Information> implements dimall.ru.interfaces.Queue<T> {

    /*
     * очередь
     */
    private HashMap<String,TreeSet<T>> queue = new HashMap();

    /**
     * получить очередь
     * @return очередь
     */
    private HashMap<String,TreeSet<T>> getQueue() {
        return this.queue;
    }

    /**
     * получить элемент группы
     * @param groupId идентификатор группы
     * @return элемент
     */

    public synchronized T get(String groupId) {
        return this.getQueue().get(groupId) != null && this.getQueue().get(groupId).size() > 0 ? this.getQueue().get(groupId).pollFirst() : null;
    }

    /**
     * поместить элемент
     * @param information элемент
     */
    @Override
    public synchronized void put(T information) {
        if (this.getQueue().get(information.getGroupId()) == null) this.getQueue().put(information.getGroupId(),new TreeSet<T>(new Comparator<T>()
        {
            @Override
            public int compare(T t1, T t2) {
                return t1.getMessageId().compareTo(t2.getMessageId());
            }
        }));
        this.getQueue().get(information.getGroupId()).add(information);
    }

    /**
     * проверить пустая ли очередь
     * @return логика
     */
    public boolean isEmpty() {
        return this.getQueue().size() == 0;
    }

    /**
     * проверить есть в очереди элементы группы
     * @param groupId идентифиакор группы
     * @return
     */
    @Override
    public boolean isEmpty(String groupId) {
        return groupId == null || this.getQueue() == null || this.isEmpty() || this.getQueue().get(groupId) == null || this.getQueue().get(groupId).size() == 0;
    }

}