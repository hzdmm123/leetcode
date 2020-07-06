package _1115_printFooBar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hzdmm123
 */
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition booCondition = lock.newCondition();
    private boolean flag = true;


    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (!flag) {
                    fooCondition.await();
                    booCondition.signal();
                }
                printFoo.run();
                flag = false;
                booCondition.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (flag) {
                    booCondition.await();
                    fooCondition.signal();
                }
                printBar.run();
                flag = true;
                fooCondition.signal();
            }
        } finally {
            lock.unlock();
        }

    }

}
// 本质上这一题是交互打印foo bar
// 首先使用一个锁
// 然后在某些条件下需要暂停执行
