package demo.lsw.com.producerconsumerdemo;

import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class Producer1 implements Runnable {

    private PriorityQueue<Integer> priorityQueue;
    public static final int MAX_SIZE = 10;

    public Producer1(PriorityQueue<Integer> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (priorityQueue){
                while(priorityQueue.size() == MAX_SIZE){
                    try {
                        priorityQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
