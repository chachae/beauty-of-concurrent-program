package cn.chachae.create_and_wait;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 生产者/消费者Demo
 *
 * @author chenyuexin
 * @since 2021/05/03 17:27
 */
public class ProvideAndConsumerDemo {

    private static final Queue<Integer> QUEUE = new ArrayDeque<>();

    private static final Integer MAX_COUNT = 10;

    public static class Provide extends Thread {

        @Override
        public void run() {

            synchronized (QUEUE) {

                while (QUEUE.size() == MAX_COUNT) {
                    try {
                        QUEUE.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                QUEUE.offer(1);
                System.out.println("生产成功");
                QUEUE.notifyAll();

            }
        }
    }

    public static class Consumer extends Thread {

        @Override
        public void run() {

            synchronized (QUEUE) {

                while (QUEUE.size() == 0) {
                    try {
                        QUEUE.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                QUEUE.poll();
                System.out.println("消费成功");
                QUEUE.notifyAll();
            }
        }

        public static void main(String[] args) {
            Provide provide = new Provide();
            Consumer consumer = new Consumer();
            new Thread(consumer).start();
            new Thread(provide).start();
        }
    }
}
