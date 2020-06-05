package arrays_and_string;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	/** initialize your data structure here. */
    private Queue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    private Queue<Integer> minHeap = new PriorityQueue<>((x, y) -> (x - y));
    public FindMedianFromDataStream() {
        ;
    }
    
    public void addNum(int num) {
        if (this.maxHeap.size() == 0){
            maxHeap.add(num);
            return;
        }
        if (num <= this.maxHeap.peek()){
            this.maxHeap.add(num);
        }else{
            this.minHeap.add(num);
        }
        balance();
        return;
    }
    
    private void balance(){
        int diffInSize = this.maxHeap.size() - this.minHeap.size();
        if (diffInSize >= 0 && diffInSize <= 1){
            return;
        }
        if (this.maxHeap.size() > this.minHeap.size()){
            this.minHeap.add(this.maxHeap.poll());
        }else{
            this.maxHeap.add(this.minHeap.poll());
        }
        return;
    }
    
    public double findMedian() {
        if (this.maxHeap.size() == this.minHeap.size()){
            return (this.maxHeap.peek() + this.minHeap.peek()) * 1.0 / 2;
        }else{
            return this.maxHeap.peek() * 1.0;
        }
    }
}
