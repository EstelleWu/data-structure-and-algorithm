package arrays_and_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	// bc return element not index, we can use two pointer algo
    // assuming the order in the solution doesn't matter
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (nums[i] > 0){
                break;
            }
            List<List<Integer>> temp = twoSum(nums, i + 1, nums.length - 1, - nums[i]);
            if (temp != null){
                for (List<Integer> l : temp){
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(nums[i]);
                    curRes.add(l.get(0));
                    curRes.add(l.get(1));
                    res.add(curRes);
                }
                
            }
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int left, int right, int target){
        int start = left;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right){
            if (left > start && nums[left] == nums[left - 1]){
                left++;
                continue;
            }
            int sum = nums[left] + nums[right];
            if (sum == target){
                List<Integer> curRes = new ArrayList<>();
                curRes.add(nums[left]);
                curRes.add(nums[right]);
                res.add(curRes);
                left++;
            }else if (sum < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
