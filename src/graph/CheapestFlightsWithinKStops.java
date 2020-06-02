package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/* Dijkstra's algo: single source shortest path
 * constraint: non-negative edge weights (once a node has been visited its optimal distance 
 * cannot be improved) -> greedy
 * variables: 
 * dist array: distance to nodes
 * min heap: (node index, distance) which node to visit next
 * main idea: iterate all edges outwards from the current node
 * */
public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		// step1: build the adjacency list
		Map<Integer, List<int[]>> adjacencyList = getAdjacencyList(flights);
		
		// step2: do dijkstra's algo, with up to K stops
		return dijkstra(adjacencyList, n, src, dst, K);
		
	}
	private int dijkstra(Map<Integer, List<int[]>> adjacencyList, int n, int src, int dst, int k) {
		// declare variables
		boolean[] visited = new boolean[n];
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		// (city, cost, # stops)
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		pq.add(new int[] {src, 0, -1});
		
		while (pq.size() > 0) {
			int[] cur = pq.poll();
			int curCity = cur[0];
			int curCost = cur[1];
			int curStop = cur[2];
			if (curCity == dst) {
				return curCost;
			}
			if (curStop >= k) {
				continue;
			}
			visited[curCity] = true;
			// next node
			if (adjacencyList.containsKey(curCity)) {
				for (int[] edge : adjacencyList.get(curCity)) {
					int nextCity = edge[0];
					int cost = edge[1];
					int nextCost = curCost + cost;
					int[] next = new int[3];
					// lazy delete
                    if (visited[nextCity]){
                        continue;
                    }
                    // already in the pq, dist has been updated
                    if (nextCost >= dist[nextCity]){
                        continue;
                    }
					next[0] = nextCity;
					next[1] = nextCost;
					next[2] = curStop + 1;
					pq.add(next);
				}
			}
		}
		return -1;
	}
	private Map<Integer, List<int[]>> getAdjacencyList(int[][] flights) {
		Map<Integer, List<int[]>> res = new HashMap<>();
		for (int[] f : flights) {
			int fromCity = f[0];
			int toCity = f[1];
			int cost = f[2];
			if (!res.containsKey(fromCity)) {
				res.put(fromCity, new ArrayList<>());
			}
			int[] edge = new int[2];
			edge[0] = toCity;
			edge[1] = cost;
			res.get(fromCity).add(edge);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
