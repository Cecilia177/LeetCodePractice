import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABCTest {
    static Object syn = new Object();
    public static String next = "a";


    public void print(){
        ExecutorService service =  Executors.newFixedThreadPool(3);
        service.execute(new APrinThread());
        service.execute(new BPrinThread());
        service.execute(new CPrinThread());

    }

    class APrinThread implements Runnable{
        @Override
        public void run() {
//            while(true){
                synchronized (syn) {
                    while(!"a".equals(next)){
                        try {
                            syn.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("a");
                    next = "b";
                    syn.notifyAll();
                }
//            }
        }
    }

    class BPrinThread implements Runnable{

        @Override
        public void run() {
//            while(true){
                synchronized (syn) {
                    while(!"b".equals(next)){
                        try {
                            syn.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.print("b");
                    next = "c";
                    syn.notifyAll();
                }
//            }

        }
    }

    class CPrinThread implements Runnable{
        @Override
        public void run() {
//            while(true){
                synchronized (syn) {
                    while(!"c".equals(next)){
                        try {
                            syn.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("c");
                    next = "a";
                    syn.notifyAll();
                }

//            }
        }

    }

}
