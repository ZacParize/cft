package dimall.ru.implementations.producers;

import dimall.ru.implementations.messages.Message;
import dimall.ru.interfaces.Broker;
import dimall.ru.interfaces.Worker;

/**
 * поток - производитель
 */
public class Producer implements Runnable, Worker {

    /*
     * имя потока
     */
    private String threadName;
    /*
     * идентификатор группы
     */
    private String groupId;
    /**
     * брокер очереди
     */
    private Broker broker;

    /**
     * конструктор потока - производителя
     * @param threadName имя потока
     * @param groupId идентификатор группы
     * @param broker брокер
     */
    public Producer(String threadName,String groupId,Broker broker)
    {
        this.threadName = threadName;
        this.groupId = groupId;
        this.broker = broker;
    }

    /**
     * получить имя потока
     * @return имя потока
     */
    @Override
    public String getThreadName() {
        return threadName;
    }

    /**
     * получить идентификатор группы
     * @return идентификатор группы
     */
    @Override
    public String getGroupId() {
        return groupId;
    }

    /**
     * получить брокера очереди
     * @return брокер очереди
     */
    @Override
    public Broker getBroker() {
        return broker;
    }

    /**
     * выполнить поток
     */
    @Override
    public void run() {
        if (this.getBroker() == null) return;
        int messageId = 1;
        try
        {
            while (!this.getBroker().isStopped()){
                Thread.sleep(800);
                this.getBroker().put(new Message(this.getGroupId(),String.valueOf(messageId),"GroupId: " + this.getGroupId() + "; MessageId: " + String.valueOf(messageId) + "; Message: " + String.valueOf(messageId++)));
            }
        }
        catch (InterruptedException ex) {
            System.out.println(this.getThreadName() + ":: gets InterruptedException");
        }
    }

}
