package demo.lsw.com.producerconsumerdemo;

import android.util.Log;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class Producer1 implements Runnable {

    private Storage mStorage;

    public Producer1(Storage storage) {
        this.mStorage = storage;
    }

    @Override
    public void run() {
        mStorage.set();
    }
}
