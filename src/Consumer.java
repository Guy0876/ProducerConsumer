import java.util.Scanner;

public class Consumer extends Thread{
    @Override
    public void run(){
        super.run();
        Scanner sc = new Scanner(System.in);
        Message msg = Message.getInstance();
        for(int i = 0; i < 10; i++){
            msg.remove();
        }
        sc.close();
    }
}
