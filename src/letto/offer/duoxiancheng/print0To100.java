package letto.offer.duoxiancheng;

public class print0To100 {

    private int a = 0;
    private final Object lock = new Object();

    public void turning() throws InterruptedException {
        new Thread(new printNum(), "线程1").start();
        Thread.sleep(100);
        new Thread(new printNum(), "线程2").start();
    }

    class printNum implements Runnable {
        @Override
        public void run() {
            while (a <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + a++);
                    lock.notifyAll();
                    try {
                        if (a <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new print0To100().turning();
    }

}
