package dimall.ru.implementations.consumers;

import dimall.ru.interfaces.Broker;
import dimall.ru.interfaces.Information;
import dimall.ru.interfaces.Worker;

/**
 * поток - потребитель
 */
public class Consumer implements Runnable,Worker {

    /*
     * имя потока
     */
    private String threadName;
    /*
     * идентификаторы групп
     */
    private String groupId;
    /*
     * брокер очереди
     */
    private Broker broker;

    /**
     * конструктор потребителя
     * @param threadName
     * @param groupId
     * @param broker
     */
    public Consumer(String threadName,String groupId,Broker broker)
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
     * получить брокер
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
    public void run()
    {
        if (this.getBroker() == null) return;
        try
        {
            Information message;
            while (!this.getBroker().isStopped()){
                Thread.sleep(900);
                message = this.getBroker().get(this.getGroupId());
                /*ВЫЗОВ МЕТОДА ПО ЗАДАНИЮ*/
                if (message != null) message.print();
            }
        }
        catch (InterruptedException ex) {
            System.out.println(this.getThreadName() + ":: gets InterruptedException");
        }
    }

}
