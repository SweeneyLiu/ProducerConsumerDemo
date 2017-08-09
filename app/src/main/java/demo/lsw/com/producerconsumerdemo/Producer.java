package demo.lsw.com.producerconsumerdemo;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * Created by liushuwei on 2017/6/19.
 */

public class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;
    private int task = 1;

    public Producer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Log.i("lsw--正在生产", task + "");
                Log.i("lsw--生产目前容量：",blockingQueue.size()+"");
                //将生产出来的产品放在队列缓存中
                blockingQueue.put(task);
                ++task;
                //让其停止一会，便于查看效果
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
