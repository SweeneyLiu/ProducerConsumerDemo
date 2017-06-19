package demo.lsw.com.producerconsumerdemo;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * Created by liushuwei on 2017/6/19.
 */

public class Consumer implements Runnable{

    private BlockingQueue<Integer> mBlockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue){
        mBlockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while(true){
            try {
                Log.i("正在消费",mBlockingQueue.take().toString());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
