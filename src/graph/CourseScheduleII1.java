package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII1 {
	static class Entry{
        Map<Integer, List<Integer>> adjacencyList;
        int[] indegree;
        Entry(Map<Integer, List<Integer>> adjacencyList, int[] indegree){
            this.adjacencyList = adjacencyList;
            this.indegree = indegree;
        }
    }
    /*
    indegree + bfs
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // step1: calculate the adjacencyList and indegree
        Entry entry = getAdjacencyListAndIndegree(numCourses, prerequisites);
        Map<Integer, List<Integer>> adjacencyList = entry.adjacencyList;
        int[] indegree = entry.indegree;
        
        // step2: do bfs, start from the node that has 0 indegree
        // indegree == 0 ~ visited
        int count = 0;
        int res[] = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while (queue.size() > 0){
            int cur = queue.poll();
            res[index] = cur;
            index++;
            count++;
            if (adjacencyList.get(cur) != null){
                for (int next : adjacencyList.get(cur)){
                    indegree[next]--;
                    if (indegree[next] == 0){
                        queue.add(next);
                    }
                }
            }
        }
        
        // step3: check if all nodes has been visited
        // the nodes in the cycle would never be added into the queue
        if (count == numCourses){
            return res;
        }else{
            return new int[]{};
        }
    }
    
    // bc I want to return objects of different type
    private Entry getAdjacencyListAndIndegree(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites){
            int prev = p[1];
            int cur = p[0];
            List<Integer> value = adjacencyList.getOrDefault(prev, new ArrayList<>());
            value.add(cur);
            adjacencyList.put(prev, value);
            indegree[cur]++;
        }
        return new Entry(adjacencyList, indegree);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
