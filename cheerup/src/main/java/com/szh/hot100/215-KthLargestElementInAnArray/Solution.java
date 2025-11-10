package com.szh.hot100;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array (数组中的第K个最大元素)
 * 
 * 题目链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/
 * 
 * 解法1：快速选择（最优解）
 * 时间复杂度：平均O(n)，最坏O(n²)
 * 空间复杂度：O(1)
 * 
 * 解法2：堆
 * 时间复杂度：O(n log k)
 * 空间复杂度：O(k)
 */
public class Solution {
    
    private Random random = new Random();
    
    /**
     * 解法1：快速选择（最优解）
     * 基于快速排序的partition思想
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        
        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    /**
     * 解法2：堆
     * 使用最小堆维护k个最大元素
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.peek();
    }
}

