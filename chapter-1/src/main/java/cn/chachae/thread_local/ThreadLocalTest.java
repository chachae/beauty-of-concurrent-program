package cn.chachae.thread_local;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @see ThreadLocal
 * @since 2021/05/04 13:26
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void print(long threadId) {
        System.out.printf("%s : %s%n", threadId, THREAD_LOCAL. get());
        THREAD_LOCAL.remove();
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            long threadId = Thread.currentThread().getId();
            // 设置 thread1的本地变量副本
            THREAD_LOCAL.set("thread1 value");
            print(threadId);
            System.out.printf("%s : after remove %s%n", threadId, THREAD_LOCAL.get());
        });

        Thread thread2 = new Thread(() -> {
            long threadId = Thread.currentThread().getId();
            // 设置 thread2的本地变量副本
            THREAD_LOCAL.set("thread2 value");
            print(threadId);
            System.out.printf("%s : after remove %s%n", threadId, THREAD_LOCAL.get());
        });
        thread1.start();
        thread2.start();
    }

}
