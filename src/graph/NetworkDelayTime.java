package graph;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
	static class Entry{
        private int key;
        private int val;
        
        Entry(int node, int dist){
            this.key = node;
            this.val = dist;
        }
        
        int getKey(){
            return this.key;
        }
        
        int getVal(){
            return this.val;
        }
    }
	
	public static Map<Integer, List<int[]>> getAdjacencyMatrix(int[][] times){
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] t : times){
            int from_node = t[0];
            int to_node = t[1];
            int cost = t[2];
            if (map.containsKey(from_node)){
            	int[] edge = {to_node, cost};
                map.get(from_node).add(edge);
            }else{
                List<int[]> l = new ArrayList<>();
                l.add(new int[]{to_node, cost});
                map.put(from_node, l);
            }
        }
        return map;
    }
    
    
    public static int networkDelayTime(int[][] times, int N, int K) {
    	// disjistra's algo
        boolean vist[] = new boolean[N+1];
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> (x.getValue() - y.getValue()));
        PriorityQueue<Entry> pq = new PriorityQueue<>((x, y) -> (x.getVal() - y.getVal()));
        pq.add(new Entry(K, 0));
        Map<Integer, List<int[]>> adjacency_matrix = getAdjacencyMatrix(times);
        
        while (pq.size() > 0){
            Entry e = pq.poll();
            int node = e.getKey();
            int possibleMinDist = e.getVal();
            vist[node] = true;
            // if already found another shorter path to this node
            // don't need continue this current path
            // (1, 5) 先进 heap, (1, 4) 后进heap. (1, 4) 先被 poll, (1, 5) 仍然在 heap 里面, 而且它会被 poll.
            // 但 4 是到达 1 的 shortest path
            if (dist[node] < possibleMinDist){
                continue;
            }else{
            	if (!adjacency_matrix.containsKey(node)) {
            		continue;
            	}
                for (int[] edge : adjacency_matrix.get(node)){
                    int to_node = edge[0];
                    int cost = edge[1];
                    // don't visite the node that we have already found the shortest path for
                    if (vist[to_node]){
                        continue;
                    }else{
                        int new_dist_for_to_node = dist[node] + cost;
                        // 当前的 to_node 为1
                        // heap 里面已经有 (1, 4) 和 (1, 5), dist[1] = 4
                        // 现在的 new_dist_for_to_node 为8, 那对 1 来说没必要走现在这个 path
                        if (new_dist_for_to_node < dist[to_node]){
                            dist[to_node] = new_dist_for_to_node;
                            pq.add(new Entry(to_node, new_dist_for_to_node));
                        }
                    }
                }
            }
        }

        
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
        	if (i != K) {
        		res = Math.max(res, dist[i]);
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int N = 4;
		int K = 2;
		System.out.println(networkDelayTime(times, N, K));
				

	}

}
