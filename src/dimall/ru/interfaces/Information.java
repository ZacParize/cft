package dimall.ru.interfaces;

/**
 * информация
 * Назначение: сущность информации
 */
public interface Information {

    /**
     * получить идетификатор группы
     * @return идентификатор группы
     */
    String getGroupId();

    /**
     * установить идентификатор группы
     * @param groupId идентификатор группы
     */
    void setGroupId(String groupId);

    /**
     * получить идентификатор
     * @return идентификатор
     */
    String getMessageId();

    /**
     * установить идентификатор
     * @param messageId идентификатор
     */
    void setMessageId(String messageId);

    /**
     * получить содержимое
     * @return
     */
    String getMessage();

    /**
     * установить содержимое
     * @param message содержимое
     */
    void setMessage(String message);

    /**
     * вывод содержимого
     */
    void print();

}
