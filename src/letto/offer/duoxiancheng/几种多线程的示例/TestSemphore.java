package letto.offer.duoxiancheng.几种多线程的示例;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemphore {
    private static final int THREAD_COUNT = 40;
    private  static  boolean fair = false;
    private static Executor executor = Executors.newFixedThreadPool(THREAD_COUNT );


    public static void main(String[] args) {
        testSemaphore(true);

    }

    public static void testSemaphore(boolean fair){
        Semaphore semaphore = new Semaphore(10,fair);
        for (int i = 0; i<THREAD_COUNT; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire(); // 超过5个会阻塞
                        System.out.println(Thread.currentThread().getName() + " acquire");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + " release");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }





}
