package com.szh.hot100;

/**
 * 240. Search a 2D Matrix II (搜索二维矩阵 II)
 * 
 * 题目链接：https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * 
 * 解法：从右上角开始搜索
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：从右上角开始搜索
     * 如果当前元素大于target，向左移动；如果小于target，向下移动
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        
        return false;
    }
}
