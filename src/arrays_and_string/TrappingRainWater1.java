package arrays_and_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater1 {
	public static int trap(int[] height) {
        if (height == null || height.length < 3){
            return 0;
        }
        
        // step1: find the first left bar
        int leftIndex = 0;
        for (int i = 0; i < height.length; i++){
            if (height[i] > 0){
                leftIndex = i;
                break;
            }
        }
        
        // step2: monotonic stack
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int leftBar = height[leftIndex];
        stack.addLast(leftBar);
        for (int i = leftIndex + 1; i < height.length; i++){
            int currentBar = height[i];
            // poll
            if (stack.size() > 0 && currentBar < stack.peekLast()){
            	int rightBar = stack.pollLast();
                while (stack.size() > 0 && rightBar > stack.peekLast()){
                    int temp = stack.pollLast();
                    res += Math.min(rightBar, leftBar) - temp;
                }
                leftBar = rightBar;
                stack.addLast(currentBar);
            }
            
            // add
            if (currentBar < leftBar){
                stack.addLast(currentBar);
            }
            
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		int res = trap(height);
		System.out.println(res);

	}

}
