package suanfa;

public class WaitThread implements Runnable {
    private Main service;

    WaitThread(Main service) {
        this.service = service;
    }

    public void run() {
        service.mWait();
    }
}