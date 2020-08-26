package letto.offer.duoxiancheng;


import java.util.Collections;

/**
 * @author myvina@qq.com
 * @date 18-5-27  下午8:00
 */

public class printabc {
    public static void main(String[] args) {
        printabc demo1 = new printabc();
        PrintLetter printLetter = demo1.new PrintLetter();
        new Thread(demo1.new PrintThread(printLetter, 'A'),"线程1").start();
        new Thread(demo1.new PrintThread(printLetter, 'B'),"线程2").start();
        new Thread(demo1.new PrintThread(printLetter, 'C'),"线程3").start();
//        Collections.synchronizedList()
    }


    private class PrintLetter {
        private char letter = 'A';

        public char getLetter() {
            return letter;
        }

        public void print() {
            System.out.print(Thread.currentThread().getName() + letter);
            if('C' == letter) {
                System.out.println();
            }
        }

        public void nextLetter() {
            switch (letter) {
                case 'A': {
                    letter = 'B';
                    break;
                }
                case 'B': {
                    letter = 'C';
                    break;
                }
                case 'C': {
                    letter = 'A';
                    break;
                }
            }
        }
    }

    private class PrintThread implements Runnable {
        private PrintLetter printLetter;
        private char letter;

        public PrintThread(PrintLetter printLetter, char letter) {
            this.printLetter = printLetter;
            this.letter = letter;
        }

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                synchronized (printLetter) {
                    while(letter != printLetter.getLetter()) {
                        try {
                            printLetter.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    printLetter.print();
                    printLetter.nextLetter();
                    printLetter.notifyAll();
                }
            }
        }
    }
}

