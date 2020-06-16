package suanfa;

public class Main {
    void mSleep() {
        synchronized (this) {
            try {
                Thread.sleep(3 * 1000);
                this.notify();
                System.out.println(" 唤醒等待 。 结束时间：" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    void mWait() {
        System.out.println(1);
        synchronized (this) {
            try {
                System.out.println(" 等待开始 。 当前时间：" + System.currentTimeMillis());
                this.wait();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void print() {
        System.out.println("Main: 123");
    }

    final void print1() {
        print();
    }

    public static void main(String[] args) {
        // Main mService = new Main();
        // Thread sleepThread = new Thread(new SleepThread(mService));
        // Thread waitThread = new Thread(new WaitThread(mService));
        // // waitThread.start();
        // sleepThread.start();
        // waitThread.start();
        Main main = new Main();
        main.print1();
    }
}

