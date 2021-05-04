package cn.chachae.daemon;

/**
 * @author <a href="mailto:chachae@foxmail.com">chachae</a>
 * @since 2021/05/04 12:20
 */
public class DaemonDemo2 {

    public static void case1() {
        Thread thread = new Thread(() -> {
            for (; ; ) {

            }
        });
        thread.start();
    }

    public static void case2() {
        Thread thread = new Thread(() -> {
            for (; ; ) {

            }
        });
        // 设置为守护
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 主线程结束，守护线程会跟着结束
     * 主线程结束，等待用户线程结束才会全部终止
     */
    public static void main(String[] args) {
        // case1();
        case2();
        System.out.println("main over");
    }

}
