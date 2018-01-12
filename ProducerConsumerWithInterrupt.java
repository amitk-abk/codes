package threads;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerWithInterrupt {

    // It acts as a buffer or queue to hold the items that are produced and to be consumed.
    // It also doubles as instrumentation of synchronization between producer and consumer.
    private List<String> queue = new LinkedList<>();
    private static int counter = 0;

    class Producer implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        String produced = "Produced:" + counter++;
                        queue.add(produced);
                        System.out.println("Produced:" + produced);
                        queue.notify();
                    }
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("===================Producer is interrupted, stopping now===============");
                        return;
                    }
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            //It may happen that queue still have an item that is to be consumed, can be done here
                            if (queue.size() > 0) {
                                System.out.println("Consumed last item:" + queue.remove(0));
                            }
                            System.out.println("=============Consumer is interrupted, stopping now=================");
                            return;
                        }
                    }
                    System.out.println("Item is Consumed:" + queue.remove(0) + "\n");
                    queue.notify();
                }
            }
        }
    }

    void startIt() {
        //Create and start producer, consumer threads
        Thread prod = new Thread(new Producer());
        Thread con = new Thread(new Consumer());
        prod.start();
        con.start();

        //Let it run for a while
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Now interrupt both producers and consumers
        prod.interrupt();
        con.interrupt();
    }

    public static void main(String[] args) {
        ProducerConsumerWithInterrupt threadInterrupt = new ProducerConsumerWithInterrupt();
        threadInterrupt.startIt();
        System.out.println("The main exists!!");
    }
}
