package cn.chachae.interrupted;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/04 11:57
 */
public class ThreadInterruptedDemo3 {

    /**
     * @see Thread#interrupted()
     */
    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(() -> {
            for (; ; ) {
            }
        });

        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        // 获取当前线程的中断标志并清除中断
        System.out.println(thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(thread.isInterrupted());
    }

}
