package com.szh.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. Course Schedule (课程表)
 * 
 * 题目链接：https://leetcode.cn/problems/course-schedule/
 * 
 * 解法：拓扑排序（DFS判断是否有环）
 * 时间复杂度：O(n + m)，其中 n 是课程数，m 是先修课程数
 * 空间复杂度：O(n + m)
 */
public class Solution {
    
    /**
     * 最优解：拓扑排序（DFS判断是否有环）
     * 使用DFS检测图中是否存在环，如果存在环则无法完成所有课程
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        // 0: 未访问, 1: 访问中, 2: 已访问
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(graph, visited, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) {
            return true; // 发现环
        }
        if (visited[node] == 2) {
            return false; // 已访问过，无环
        }
        
        visited[node] = 1; // 标记为访问中
        
        for (int neighbor : graph.get(node)) {
            if (hasCycle(graph, visited, neighbor)) {
                return true;
            }
        }
        
        visited[node] = 2; // 标记为已访问
        return false;
    }
}
