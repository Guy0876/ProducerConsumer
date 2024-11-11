public class Message {
    private static Message instance = null;

    private String message = "";
    private boolean empty = true;

    private Message(){}

    public static synchronized Message getInstance(){
        if(instance == null){
            Message msg = new Message();
            instance = msg;
        }
        return instance;
    }

    public synchronized void insert(String newMessage) {
        if(!this.empty)
        {
            try {
                instance.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = newMessage;
        this.empty = false;
        System.out.println("the message is: " + newMessage);
        instance.notify();
    }

    public synchronized void remove() {

        if(this.empty)
        {
            try {
                instance.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = "";
        this.empty = true;
        System.out.println("the message has been removed!");
        instance.notify();
    }

    public boolean isEmpty() {
        return empty;
    }
}
