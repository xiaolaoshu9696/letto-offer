package letto.offer.duoxiancheng;


public class printabcusecondition {

    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintThread("A", 0, lock)).start();
        new Thread(new PrintThread("B", 1, lock)).start();
        new Thread(new PrintThread("C", 2, lock)).start();
    }

}


class PrintThread  implements Runnable{
    private String symbol;
    private int go;
    private final Object lock;
    private static int i = 0;

    public PrintThread(String symbol, int go, Object lock) {
        this.symbol = symbol;
        this.lock = lock;
        this.go = go;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    while (i % 3 != go) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " "+ symbol);
                i++;
                lock.notifyAll();
            }
        }
    }
}




