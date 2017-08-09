package demo.lsw.com.producerconsumerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testProducerConsumer1();
        testProducerConsumer2();
    }

    /**
     * 通过wait()/notify()/notifyAll()实现
     */
    private void testProducerConsumer2() {
        Storage storage = new Storage();
        Producer1 product1 = new Producer1(storage);
        Consumer1 consumer1 = new Consumer1(storage);
        new Thread(product1).start();
        new Thread(consumer1).start();
    }

    /**
     * 通过BlockingQueue实现生产者消费者
     */
    private void testProducerConsumer1(){

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }
}
