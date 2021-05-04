package cn.chachae.create_and_wait;

import java.util.concurrent.TimeUnit;

/**
 * 死锁 demo
 *
 * @author chenyuexin
 * @since 2021/05/03 19:21
 */
public class DeathThreadDemo {

    private static final String O1 = "1";
    private static final String O2 = "2";

    public void lockObjectCase1(String lockedObj1, String lockedObj2) {

        synchronized (lockedObj1) {
            System.out.printf("%s : %s locked%n", Thread.currentThread().getId(), lockedObj1);

            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (Exception e) {
                e.printStackTrace();
            }

            synchronized (lockedObj2) {
                System.out.printf("%s : try to lock : %s %n", Thread.currentThread().getId(), lockedObj2);
            }

        }
    }

    public void lockObjectCase2(String lockedObj1, String lockedObj2, boolean isWait) {
        try {

            System.out.printf("%s : try to lock : %s %n", Thread.currentThread().getId(), lockedObj1);

            synchronized (lockedObj1) {

                System.out.printf("%s : %s locked%n", Thread.currentThread().getId(), lockedObj1);

                TimeUnit.SECONDS.sleep(1L);

                if (isWait) {
                    lockedObj1.wait();
                } else {
                    lockedObj1.notifyAll();
                }

                System.out.printf("%s : try to lock : %s %n", Thread.currentThread().getId(), lockedObj2);

                synchronized (lockedObj2) {

                    System.out.printf("%s : %s locked%n", Thread.currentThread().getId(), lockedObj2);

                    if (isWait) {
                        lockedObj2.wait();
                    } else {
                        lockedObj2.notifyAll();
                    }

                    TimeUnit.SECONDS.sleep(3L);
                    lockedObj2.wait();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        // new Thread(() -> new DeathThreadDemo().lockObjectCase1(O1, O2)).start();
        // new Thread(() -> new DeathThreadDemo().lockObjectCase1(O2, O1)).start();

        Thread ta = new Thread(() -> new DeathThreadDemo().lockObjectCase2(O1, O2, true));
        Thread tb = new Thread(() -> new DeathThreadDemo().lockObjectCase2(O1, O2, true));

        ta.start();
        tb.start();

        ta.join();
        tb.join();

        System.out.println("main end");

    }

}
