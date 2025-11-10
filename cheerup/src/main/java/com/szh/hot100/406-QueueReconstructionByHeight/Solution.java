package com.szh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height (根据身高重建队列)
 * 
 * 题目链接：https://leetcode.cn/problems/queue-reconstruction-by-height/
 * 
 * 解法：排序 + 插入
 * 时间复杂度：O(n²)
 * 空间复杂度：O(n)
 */
public class Solution {
    
    /**
     * 最优解：排序 + 插入
     * 1. 按身高降序、k值升序排序
     * 2. 按照k值插入到对应位置
     */
    public int[][] reconstructQueue(int[][] people) {
        // 按身高降序，如果身高相同则按k值升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
