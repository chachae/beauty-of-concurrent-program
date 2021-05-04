package cn.chachae.create_thread_and_run;

/**
 * @author chenyuexin
 * @since 2021/05/03 15:59
 */
public class RunnableTest {

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
    }

}
