package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
	static int index = 0;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // step1: build adjacency list
        Map<Integer, List<Integer>> adjacencyList = getAdjacencyList(prerequisites);
        
        // step2: try to use dfs to check if contains cycle
        int[] res = new int[numCourses];
        CourseScheduleII.index = numCourses - 1;
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
                boolean[] visiting = new boolean[numCourses];
                if (findOrderHelper(i, adjacencyList, visited, visiting, res)){
                    return new int[]{};
                }
            }
        }
        return res;
    }
    
    private static Map<Integer, List<Integer>> getAdjacencyList(int[][] prerequisites){
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int[] p : prerequisites){
            int prev = p[1];
            int cur = p[0];
            List<Integer> value = res.getOrDefault(prev, new ArrayList<>());
            value.add(cur);
            res.put(prev, value);
        }
        return res;
    }
    
    private static boolean findOrderHelper(int cur, Map<Integer, List<Integer>> adjacencyList, boolean[] visited, boolean[] visiting, int[] res){
        // mark as visiting
        if (visiting[cur]){
            return true;
        }
        visiting[cur] = true;
        if (adjacencyList.get(cur) != null){
            // loop through children
            for (int next : adjacencyList.get(cur)){
                if (!visited[next]){
                    if (findOrderHelper(next, adjacencyList, visited, visiting, res)){
                        return true;
                    }
                }
            }
        }
        // mark as visited
        visited[cur] = true;
        res[CourseScheduleII.index] = cur;
        CourseScheduleII.index--;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;
		int[][] prerequisites = {{0,1},{1,0}};
		int[] res = findOrder(numCourses, prerequisites);
		System.out.println(res);

	}

}
