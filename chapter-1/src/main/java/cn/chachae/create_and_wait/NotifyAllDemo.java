package cn.chachae.create_and_wait;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/03 20:34
 */
public class NotifyAllDemo {

    private static final Object o1 = new Object();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                synchronized (o1) {
                    System.out.println("t1 lock resource");
                    o1.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("t1 end");
        });


        Thread t2 = new Thread(() -> {
            try {
                synchronized (o1) {
                    System.out.println("t2 lock resource");
                    o1.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("t2 end");
        });

        Thread t3 = new Thread(() -> {
            try {
                synchronized (o1) {
                    System.out.println("t3 lock resource");
                    o1.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("t3 end");
        });

        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2L);
        t3.start();
    }
}
