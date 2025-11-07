package com.szh.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges (腐烂的橘子)
 * 
 * 题目链接：https://leetcode.cn/problems/rotting-oranges/
 * 
 * 解法：BFS（广度优先搜索）
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class Solution {
    
    /**
     * 最优解：BFS
     * 使用队列进行多源BFS，统计需要的时间
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // 将所有腐烂的橘子加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        freshCount--;
                        hasRotten = true;
                    }
                }
            }
            
            if (hasRotten) {
                minutes++;
            }
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}
