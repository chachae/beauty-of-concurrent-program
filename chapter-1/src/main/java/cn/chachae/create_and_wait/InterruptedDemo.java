package cn.chachae.create_and_wait;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/03 19:59
 */
public class InterruptedDemo {

    static final Object o1 = new Object();

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("begin");

                synchronized (o1) {
                    o1.wait();
                }

                System.out.println("end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();

        TimeUnit.SECONDS.sleep(1L);
        t1.interrupt();

    }

}
