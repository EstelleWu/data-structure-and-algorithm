package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	/*
    use topological sort to check cycle
    */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // step1: build adjacency list
        Map<Integer, List<Integer>> adjacencyList = getAdjacencyList(prerequisites);
        
        // step2: try to use dfs to check if contains cycle
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
                boolean[] visiting = new boolean[numCourses];
                if (containsCycle(i, adjacencyList, visited, visiting)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private static Map<Integer, List<Integer>> getAdjacencyList(int[][] prerequisites){
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int[] p : prerequisites){
            int prev = p[1];
            int cur = p[0];
            List<Integer> value = res.getOrDefault(prev, new ArrayList<>());
            value.add(cur);
            res.put(prev, value);
            // res.put(prev, res.getOrDefault(prev, new ArrayList<>()).add(cur));
            //               add() return a boolean
        }
        return res;
    }
    
    private static boolean containsCycle(int cur, Map<Integer, List<Integer>> adjacencyList, boolean[] visited, boolean[] visiting){
        if (visiting[cur]){
            return true;
        }
        visiting[cur] = true;
        if (adjacencyList.get(cur) != null){
            for (int next : adjacencyList.get(cur)){
                if (!visited[next]){
                    if (containsCycle(next, adjacencyList, visited, visiting)){
                        return true;
                    }
                }
            }
        }
        visited[cur] = true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;	
		int[][] prerequisites = {{1, 0}};
		boolean res = canFinish(numCourses, prerequisites);
		System.out.println(res);
	}

}
