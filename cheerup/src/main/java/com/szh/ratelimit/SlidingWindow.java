package com.szh.ratelimit;

import java.util.concurrent.TimeUnit;

public class SlidingWindow {

    private int capacity;
    private long time;
    private TimeUnit timeUnit;
    private int minWindowCount;
}
