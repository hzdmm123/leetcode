package _1114_orderPrint;

import java.util.concurrent.CountDownLatch;

/**
 * @author hzdmm123
 */
public class Foo2 {

    CountDownLatch latch1;
    CountDownLatch latch2;

    public Foo2() {
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        printSecond.run();
        latch2.countDown();


    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        printThird.run();

    }
}

/**
 *执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 10 ms
 * , 在所有 Java 提交中击败了
 * 95.29%
 * 的用户
 * 内存消耗 :
 * 35.4 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
*/