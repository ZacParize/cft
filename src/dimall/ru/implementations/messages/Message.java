package dimall.ru.implementations.messages;

import dimall.ru.interfaces.Information;

/**
 * Сообщение
 */
public class Message implements Information {

    /*
     * идентификатор группы
     */
    private String groupId;
    /*
     * идентификатор сообщения
     */
    private String messageId;
    /*
     * содержимое сообщения
     */
    private String message;

    /**
     * конструктор
     * @param groupId идентификатор группы
     * @param messageId идентификатор сообщения
     * @param message содержимое сообщения
     */
    public Message(String groupId,String messageId, String message) {
        this.setGroupId(groupId);
        this.setMessageId(messageId);
        this.setMessage(message);
    }

    /**
     * получить идетификатор группы
     * @return идентификатор группы
     */
    @Override
    public String getGroupId() {
        return groupId;
    }

    /**
     * установить идентификатор группы
     * @param groupId идентификатор группы
     */
    @Override
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * получить идентификатор сообщения
     * @return идентификатор сообщения
     */
    @Override
    public String getMessageId() {
        return messageId;
    }

    /**
     * установить идентификатор сообщения
     * @param messageId идентификатор сообщения
     */
    @Override
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * получить содержимое сообщения
     * @return содержимое сообщения
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * установить содержимое сообщения
     * @param message содержимое сообщение
     */
    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * вывод содержимого
     */
    @Override
    public void print() {
        System.out.println(this.getMessage());
    }

}
