public class DeadLock {
    public void test() {
        MyTask task1 = new MyTask(true);
        MyTask task2 = new MyTask(false);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }
}

class MyTask implements Runnable {

    private boolean flag = true;

    private static Object objA = new Object();
    private static Object objB = new Object();

    public MyTask(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag) {
            synchronized (objA) {
                System.out.println(Thread.currentThread().getName() + " gets objA..");
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objB) {
                    System.out.println(Thread.currentThread().getName() + " gets objB..");
                }
            }

        } else {
            synchronized (objB) {
                System.out.println(Thread.currentThread().getName() + " gets objB..");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + " gets objA..");
                }
            }

        }
    }
}
