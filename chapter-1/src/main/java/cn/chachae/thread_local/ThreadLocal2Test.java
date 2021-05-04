package cn.chachae.thread_local;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @see ThreadLocal
 * @since 2021/05/04 13:26
 */
public class ThreadLocal2Test {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void print(long threadId) {
        System.out.printf("%s : %s%n", threadId, THREAD_LOCAL.get());
        THREAD_LOCAL.remove();
    }

    public static void main(String[] args) {

        THREAD_LOCAL.set("main thread value");

        // 设置 thread1的本地变量副本
        Thread thread1 = new Thread(() -> print(Thread.currentThread().getId()));

        thread1.start();
        System.out.printf("%s : %s%n", Thread.currentThread().getId(), THREAD_LOCAL.get());
    }

}
