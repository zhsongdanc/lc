package com.szh.hot100;

/**
 * 075. Sort Colors (颜色分类)
 * 
 * 题目链接：https://leetcode.cn/problems/sort-colors/
 * 
 * 解法：双指针（荷兰国旗问题）
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：双指针（荷兰国旗问题）
     * 使用三个指针：left指向0的右边界，right指向2的左边界，current遍历数组
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        
        while (current <= right) {
            if (nums[current] == 0) {
                // 交换到左边
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                // 交换到右边
                swap(nums, right, current);
                right--;
                // 注意：这里不移动current，因为交换过来的元素还需要检查
            } else {
                // 1保持不变
                current++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

