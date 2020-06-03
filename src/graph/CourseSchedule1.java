package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule1 {
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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step1: calculate the adjacencyList and indegree
        Entry entry = getAdjacencyListAndIndegree(numCourses, prerequisites);
        Map<Integer, List<Integer>> adjacencyList = entry.adjacencyList;
        int[] indegree = entry.indegree;
        
        // step2: do bfs, start from the node that has 0 indegree
        // indegree == 0 ~ visited
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while (queue.size() > 0){
            int cur = queue.poll();
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
        return count == numCourses;
    }
    
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
}
