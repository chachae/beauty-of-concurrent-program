package cn.chachae.daemon;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/04 12:15
 */
public class DaemonDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
        });

        // 设置守护线程
        thread.setDaemon(true);
        thread.start();
    }

}
