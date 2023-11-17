package com.szh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/17 10:05
 */
public class S56 {

    public static void main(String[] args) {
        int[] x1 = {1,3};
        int[] x2 = {2,6};
        int[] x3 = {8,10};
        int[] x4 = {15,18};

        int[][] tmp = {x1,x2,x3,x4};
        int[][] merge = new Solution().merge(tmp);
        System.out.println("");
//        new ArrayList<>().subList()
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        sortArray(intervals);


        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                j++;
            } else {
                res.add(intervals[i]);
                i = j;
                j++;
            }
        }
        res.add(intervals[i]);

        int[][] tmp = new int[res.size()][];
        for (int k = 0; k < res.size(); k++) {
            tmp[k] = res.get(k);
        }
        return tmp;

    }

    private void sortArray(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });



    }
}
