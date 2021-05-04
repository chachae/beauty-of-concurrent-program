package cn.chachae.create_thread_and_run;

/**
 * @author chenyuexin
 * @since 2021/05/03 15:50
 */
public class ThreadTest {

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
