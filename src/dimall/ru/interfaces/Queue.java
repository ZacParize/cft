package dimall.ru.interfaces;

/**
 * Очередь
 * @param <T> содержимое
 */
public interface Queue<T extends Information> {

    /**
     * получить очередной элемент
     *
     * @param groupId идентификатор группы
     * @return очередной элемент
     */
    T get(String groupId);

    /**
     * проверить есть ли элемент заданной группы
     *
     * @param groupId
     * @return логика
     */
    boolean isEmpty(String groupId);

    /**
     * поместить элемент в очереди
     *
     * @param information элемент
     */
    void put(T information);

}