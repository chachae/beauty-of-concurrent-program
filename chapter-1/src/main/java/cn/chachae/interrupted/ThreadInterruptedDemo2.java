package cn.chachae.interrupted;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/04 11:57
 */
public class ThreadInterruptedDemo2 {

    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(() -> {
            try {
                System.out.println(String.format("%s : begin sleep 20000", Thread.currentThread().getId()));
                Thread.sleep(20000);
                System.out.println(String.format("%s : over sleep 20000", Thread.currentThread().getId()));
            } catch (Exception e) {
                System.out.println(String.format("%s : is interrepted while sleep", Thread.currentThread().getId()));
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println("main interrupted");
        thread.interrupt();
        thread.join();
        System.out.println("main exit");
    }

}
