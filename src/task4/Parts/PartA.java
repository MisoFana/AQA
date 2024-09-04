package task4.Parts;

public class PartA {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiting...");
                    lock.wait();
                    System.out.println("Notified!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread signalingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(10000);
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        waitingThread.start();
        signalingThread.start();
    }
}
