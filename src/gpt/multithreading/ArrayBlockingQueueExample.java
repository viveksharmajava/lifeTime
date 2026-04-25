package gpt.multithreading;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        // Producer
        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("Produced 1");
                queue.put(2);
                System.out.println("Produced 2");
                System.out.println("Producing");
                queue.put(3); // Will block until space is free
                System.out.println("Produced 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Consumed " + queue.take());
                System.out.println("Consumed " + queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
