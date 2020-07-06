package _1114_orderPrint;

/**
 * @author hzdmm123
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Foo {
    volatile int signal = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        signal = 1;

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (signal != 1) ;// =1 说明执行过first了
        printSecond.run();
        signal = 2;

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (signal != 2) ;// =2 说明执行过second了，可以执行了
        printThird.run();
    }
}
/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 10 ms
 * , 在所有 Java 提交中击败了
 * 95.29%
 * 的用户
 * 内存消耗 :
 * 35.8 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */
