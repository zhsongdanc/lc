package com;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/24 20:25
 */
public class JVMMemoryTest {

    public static void main(String[] args) {


        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        long usedHeapMemory = heapMemoryUsage.getUsed();
        long maxHeapMemory = heapMemoryUsage.getMax();
        double heapMemoryUsagePercentage = ((double) usedHeapMemory / maxHeapMemory) * 100.0;

        System.out.println("Used Heap Memory: " + usedHeapMemory + " bytes");
        System.out.println("Max Heap Memory: " + maxHeapMemory + " bytes");
        System.out.println("Heap Memory Usage Percentage: " + heapMemoryUsagePercentage + "%");

        byte[] bytes = new byte[1024 * 1024 * 10];
        for (byte aByte : bytes) {
            aByte = Byte.parseByte("123");
        }

        System.gc(); // 手动触发垃圾回收

        usedHeapMemory = heapMemoryUsage.getUsed();
        heapMemoryUsagePercentage = ((double) usedHeapMemory / maxHeapMemory) * 100.0;

        System.out.println("Used Heap Memory after GC: " + usedHeapMemory + " bytes");
        System.out.println("Heap Memory Usage Percentage after GC: " + heapMemoryUsagePercentage + "%");

    }
}
