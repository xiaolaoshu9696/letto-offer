package letto.offer.duoxiancheng;

public class print0to100use5thread {

    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(new printThread(lock,0),"线程1").start();
        new Thread(new printThread(lock,1),"线程2").start();
        new Thread(new printThread(lock,2),"线程3").start();
        new Thread(new printThread(lock,3),"线程4").start();
        new Thread(new printThread(lock,4),"线程5").start();
    }

}


class printThread implements Runnable{
    private final Object lock;
    private static int num = 0;
    private int go;

    public printThread(Object lock, int go) {
        this.lock = lock;
        this.go = go;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    while (num % 5 != go) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num>100) break;
                System.out.println(Thread.currentThread().getName() + " "+ num);
                num++;
                lock.notifyAll();
            }
        }
    }
}

