package demo.lsw.com.producerconsumerdemo;



/**
 * Created by Administrator on 2017/7/5 0005.
 */

public class Consumer1 implements Runnable {

    private Storage mStorage;

    public Consumer1(Storage storage) {
        mStorage = storage;
    }

    @Override
    public void run() {
        mStorage.get();
    }
}
