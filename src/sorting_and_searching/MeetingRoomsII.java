package sorting_and_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            if (pq.peek() <= intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);  
        }
        return pq.size();
    }
}
