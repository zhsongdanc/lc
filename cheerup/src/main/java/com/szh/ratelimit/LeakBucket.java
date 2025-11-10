package com.szh.ratelimit;

import java.util.LinkedList;
import java.util.Queue;

public class LeakBucket {

    public LeakBucket(int capacity, long leakSpeed) {
        this.capacity = capacity;
    }

    private int capacity;
    private long leakSpeed;
    private Queue<Object> queue = new LinkedList<Object>();

    public Object rateLimit(Object obj) {
        if (queue.size() < capacity) {
            queue.add(obj);
            try {
                Thread.sleep(leakSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return queue.remove();
        }
        return null;
    }

}
