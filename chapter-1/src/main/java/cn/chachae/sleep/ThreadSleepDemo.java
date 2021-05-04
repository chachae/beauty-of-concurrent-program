package cn.chachae.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/04 11:29
 */
public class ThreadSleepDemo {

    private static final Lock LOCK = new ReentrantLock();

    public static void process1() {
        LOCK.lock();
        try {
            System.out.println("process1 exec");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
            System.out.println("process1 exit");
        }
    }

    public static void process2() {
        LOCK.lock();
        try {
            System.out.println("process2 exec");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
            System.out.println("process2 exit");
        }
    }

    public static void main(String[] args) {
        process1();
        process2();
    }

}
