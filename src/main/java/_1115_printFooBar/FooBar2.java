package _1115_printFooBar;

/**
 * @author hzdmm123
 */
public class FooBar2 {

    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    private Object lock = new Object();
    private boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                if (!flag) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                lock.notifyAll();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                if (flag) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                lock.notifyAll();
            }
        }

    }
}
