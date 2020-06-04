package arrays_and_string;
/*

0   1 2 -> 1
1   2 3 -> 1
2   2 3 -> 2
for each ele, find the closest left and right border
left border: 
if height[i] > height[i+1], keep going left; else break border at index i+1
left and right borders: n^2

[0,1,0,2,1,0,1,3,2,1,2,1]
[0,0,1,1,2,2,2,2,3,3,3,3]
[3,3,3,3,3,3,3,2,2,2,1,0]
 |
highest bar on left and highest bar on right
*/
public class TrappingRainWater {
	public int trap(int[] height) {
        if (height == null || height.length == 0 || height.length == 1 || height.length == 2){
            return 0;
        }
        int res = 0;
        // step1: find the highest bar for both sides
        int[] highestBarOnLeft = new int[height.length];
        int left = 0;
        for (int i = 1; i < height.length; i++){
            left = Math.max(left, height[i - 1]);
            highestBarOnLeft[i] = left;
        }
        int right = 0;
        int[] highestBarOnRight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--){
            right = Math.max(right, height[i + 1]);
            highestBarOnRight[i] = right;
        }
        
        
        // step2: calculate the amount of water can be trapped in each index
        for (int i = 0; i < height.length; i++){
            int temp = Math.min(highestBarOnLeft[i], highestBarOnRight[i]);
            if (temp > height[i]){
                res += temp - height[i];
            }
        }
        return res;
        
    }
}
