package arrays_and_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater1 {
	/*
    monotonic stack, pop when the current bar is higher than its previous bar
    */
    public static int trap(int[] height) {
        // store index in stack
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int rightIndex = 0; rightIndex < height.length; rightIndex++){
            while (stack.size() > 0 && height[stack.peekLast()] < height[rightIndex]){
                int bottomIndex = stack.pollLast();
                // no left bar to bound
                if (stack.size() == 0){
                    break;
                }
                int leftIndex = stack.peekLast();
                int water = (rightIndex - leftIndex - 1) * (Math.min(height[rightIndex], height[leftIndex]) - height[bottomIndex]);
                res += water;
            }
            stack.addLast(rightIndex);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] height = {1,2,3,4,5};
		int res = trap(height);
		System.out.println(res);

	}

}
