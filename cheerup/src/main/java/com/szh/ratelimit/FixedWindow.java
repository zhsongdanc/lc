package com.szh.ratelimit;

import java.util.concurrent.TimeUnit;

public class FixedWindow {

    public FixedWindow(TimeUnit timeUnit, long time, int capacity) {
        this.capacity = capacity;
        this.timeUnit = timeUnit;
        this.time = time;
    }

    // 1min处理60个req
    private int capacity ;
    private TimeUnit timeUnit;
    private long time;
    private int used = 0;

    private long startTime = System.currentTimeMillis();

    public synchronized boolean rateLimit(String key) {
        if (System.currentTimeMillis() - startTime > timeUnit.toMillis(time)) {
            startTime = System.currentTimeMillis();
            used = 1;
            return true;
        }
        if (used < capacity) {
            used++;
            return true;
        }
        return false;
    }
}
