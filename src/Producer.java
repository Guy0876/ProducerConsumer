import java.util.*;
public class Producer extends Thread {

    @Override
    public void run(){
        super.run();
        Scanner sc = new Scanner(System.in);
        Message msg = Message.getInstance();
        for(int i = 0; i < 10; i++){
            String message = sc.next();
            msg.insert(message);
        }
        sc.close();
    }
}
