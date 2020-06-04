package arrays_and_string;

public class ContainerWithMostWater {
	/*
    brute force -> two pointers
    height * width
    width: from two end to the middle, decreasing -> two pointers
    height: replace the shorter one
    */
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length == 0){
            return res;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            res = Math.max(res, w * h);
            if (height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
