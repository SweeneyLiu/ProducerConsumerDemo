package demo.lsw.com.producerconsumerdemo;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liushuwei on 2017/8/9.
 */

public class Storage {
    private int maxSize;

    private LinkedList<String> mStringList;

    public Storage() {
        maxSize = 10;
        mStringList = new LinkedList<>();
    }

    public synchronized void set() {
        while(true){
            if(mStringList.size() == maxSize){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mStringList.add("test");
            Log.i("lsw---set--", "" + mStringList.size());
            notifyAll();
        }
    }

    public synchronized void get() {
        while (true) {
            if (mStringList.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            Log.i("lsw---get-size-", "" + mStringList.size());
            Log.i("lsw---get--element = ", "" + mStringList.poll());
            Log.i("lsw---get-poll-size-", "" + mStringList.size());
            notifyAll();
        }
    }
}
