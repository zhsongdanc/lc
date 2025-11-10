package com.szh.hot100;

/**
 * 048. Rotate Image (旋转图像)
 * 
 * 题目链接：https://leetcode.cn/problems/rotate-image/
 * 
 * 解法：先转置再翻转
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：先转置再翻转
     * 1. 先沿主对角线转置矩阵
     * 2. 再水平翻转每一行
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // 水平翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

