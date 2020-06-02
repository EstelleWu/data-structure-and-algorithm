package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops1 {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		// step1: build the adjacency list
		Map<Integer, List<int[]>> adjacencyList = getAdjacencyList(flights);
		
		// step2: do dijkstra's algo, with up to K stops
		return bfs(adjacencyList, n, src, dst, K);
		
	}
	private int bfs(Map<Integer, List<int[]>> adjacencyList, int n, int src, int dst, int k) {
		int res = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        // (city, cost)
		q.add(new int[] {src, 0});
		int stops = -2;
		while (q.size() > 0) {
			stops++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int curCity = cur[0];
				int curCost = cur[1];
				if (curCity == dst) {
					return curCost;
				}
				if (adjacencyList.containsKey(curCity)) {
					for (int[] edge : adjacencyList.get(curCity)) {
						int nextCity = edge[0];
						int nextCost = curCost + edge[1];
						q.add(new int[] {nextCity, nextCost});
					}
				}
			}
			if (stops >= k) {
				return -1;
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
