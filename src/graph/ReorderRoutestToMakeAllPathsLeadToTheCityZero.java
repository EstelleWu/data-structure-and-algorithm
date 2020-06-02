package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ReorderRoutestToMakeAllPathsLeadToTheCityZero {
	/*
	 * normal tree: root is 0, from 0 to all the other nodes
	 * this tree: from all the other nodes to 0
	 * traverse the tree, bfs or dfs
	 * */
	public static int minReorder(int n, int[][] connections) {
		
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		/* bc later, we start from 0
		 * we need to differentiate outgoing edge and incoming edge
		 * [0, 1]
		 * for 0: outgoing to 1, this is wrong, +1
		 * for 1: outgoing to 0, should be this one
		*/
		for (int[] c : connections) {
			int fromCity = c[0];
			int toCity = c[1];
			Set<Integer> fromCityValue = graph.getOrDefault(fromCity, new HashSet());
			fromCityValue.add(- toCity);
			graph.put(fromCity, fromCityValue);
			Set<Integer> toCityValue = graph.getOrDefault(toCity, new HashSet());
			toCityValue.add(fromCity);
			graph.put(toCity, toCityValue);	
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		boolean[] visited = new boolean[n];
		visited[0] = true;
		int res = 0;
		while (queue.size() > 0) {
			int city = queue.poll();
			for (int nextCity : graph.get(city)) {
				if (visited[Math.abs(nextCity)]) {
					continue;
				}
				// 怎么想到这个的？！！！
				if (nextCity < 0) {
					nextCity = - nextCity;
					res += 1;
				}
				queue.add(nextCity);
				visited[nextCity] = true;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		int res = minReorder(n, connections);
		System.out.println(res);

	}

}
