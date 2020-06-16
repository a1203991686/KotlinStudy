package suanfa;

public class SleepThread implements Runnable {
    private Main service;

    SleepThread(Main service) {
        this.service = service;
    }

    public void run() {
        service.mSleep();
    }

}