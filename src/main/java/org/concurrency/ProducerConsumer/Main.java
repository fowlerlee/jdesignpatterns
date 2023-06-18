package org.concurrency.ProducerConsumer;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

class Producer<T> implements Runnable {
    AtomicReference<ThreadSafeQueue<Integer>> safeQueue;

    public Producer(ThreadSafeQueue<Integer> t) {
        safeQueue = new AtomicReference<>(t);
    }

    @Override
    public void run() {
        IntStream.range(0, 10000).forEachOrdered(i -> {
            try {
                safeQueue.get().push(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

class Consumer<T> implements Runnable {
    AtomicReference<ThreadSafeQueue<Integer>> safeQueue;

    public Consumer(ThreadSafeQueue<Integer> t) {
        safeQueue = new AtomicReference<>(t);
    }

    @Override
    public void run() {
        IntStream.range(0, 10000).forEachOrdered(i -> {
            try {
                System.out.println(safeQueue.get().pop());
                // only process 99% of the values
                if (i == 10000 * 99 / 100)
                    System.exit(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

/**
 * queue with first in first out (FIFO) processing
 * and holds only 5 items at a time
 *
 * @param <T>
 */
class ThreadSafeQueue<T> {
    private List<T> queue = new LinkedList<>();
    private int CAPACITY = 5;

    public ThreadSafeQueue(List<T> queue) {
        this.queue = queue;
    }

    /**
     * add to the front
     *
     * @param t
     */
    public synchronized void push(T t) throws InterruptedException {
        if (queue.size() <= 5) {
            queue.add(t);
            this.notify();
        }
        this.wait();
    }

    /**
     * remove from the back
     *
     * @return
     */
    public synchronized T pop() throws InterruptedException {
        T remove = null;
        if (queue.size() > 0 && queue.size() < 5) {
            remove = queue.remove(0);
            this.notify();
        }
        this.wait(2000);
        return remove;
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadSafeQueue<Integer> iQ = new ThreadSafeQueue<>(new LinkedList<>());
        Producer p = new Producer(iQ);
        Consumer c = new Consumer(iQ);
        new Thread(p).start();
        new Thread(c).start();
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        //executorService.submit(p);
        //executorService.submit(c);
    }
}
