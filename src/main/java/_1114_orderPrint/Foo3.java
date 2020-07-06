package _1114_orderPrint;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hzdmm123
 */
public class Foo3 {

    Semaphore semaphore = new Semaphore(1);
    Semaphore semaphore1 = new Semaphore(0);
    Semaphore semaphore2 = new Semaphore(0);

    public Foo3() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphore.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
