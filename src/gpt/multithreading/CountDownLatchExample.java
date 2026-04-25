package gpt.multithreading;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " working");
            try { Thread.sleep(1000); } catch (Exception e) {}

            System.out.println(Thread.currentThread().getName() + " done");
            latch.countDown();
        };

        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();

        System.out.println("Main thread waiting...");
        latch.await(); // wait until count = 0

        System.out.println("All workers finished. Main continues.");
    }
}