import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintInOrder {
    private boolean firstFinished = false;
    private boolean secondFinished = false;
    private Object obj = new Object();

    public void print() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new printA());
        executorService.execute(new printB());
        executorService.execute(new printC());
    }

    class printA implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "...one");
                firstFinished = true;
                obj.notifyAll();
            }
        }
    }

    class printB implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                while (!firstFinished) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {

                    }

                }
                System.out.println(Thread.currentThread().getName() + "...two");
                secondFinished = true;
                obj.notifyAll();
            }
        }
    }

    class printC implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {
                while (!secondFinished) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {

                    }

                }
                System.out.println(Thread.currentThread().getName() + "...Three");
            }
        }
    }
}

class PrintOrder2 {
    public void print() {
        
    }
}
