package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/11/24 16:32
 */
public class SlidingWindowTest {


//    测试结果:[-1,-3,5,3,6,7]
//    期望结果:[3,3,5,5,6,7]
    public static void main(String[] args) {
        int k = 3;
        // nums = [1,3,-1,-3,5,3,6,7]
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, k);
    }

    public static  int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        // 维护一个单调递减的队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int end = 0; end < nums.length; end++) {


            while (!queue.isEmpty() && queue.peekFirst() < end - k + 1) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[end] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.add(end);
            if (end + 1 >= k) {
                res.add(queue.peekFirst());
            }

        }

        int[] array = new int[res.size()];
        for (int j = 0;j < res.size();j++) {
            array[j] = res.get(j);
        }
        return array;
    }

}
