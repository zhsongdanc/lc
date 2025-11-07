package com.szh.hot100;

/**
 * 200. Number of Islands (岛屿数量)
 * 
 * 题目链接：https://leetcode.cn/problems/number-of-islands/
 * 
 * 解法：DFS（深度优先搜索）
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class Solution {
    
    /**
     * 最优解：DFS
     * 遍历网格，遇到'1'时进行DFS，将相连的'1'都标记为'0'
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

