package arrays_and_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	/*
    about the input: not sorted
    so, if we sort and then use two pointers algo, we have to record the original index for each element
    hashmap + two pointers: doable but not recommended
    
    brutal force: for each element, find the complement
    */
    public static int[] twoSum(int[] nums, int target) {
        // step1: build the indexMap
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            List<Integer> indice = map.getOrDefault(nums[i], new ArrayList<>());
            indice.add(i);
            map.put(nums[i], indice);
        }
        
        
        // step2: find the pair
        int[] res = new int[2];
        for (int n : nums){
            int complement = target - n;
            if (map.containsKey(complement)){
                if (n == complement){
                    if (map.get(n).size() == 2){
                        res = map.get(n).stream().mapToInt(i -> i).toArray();
                        System.out.println(res);
                        return res;
                    }
                }else{
                    res[0] = map.get(n).get(0);
                    res[1] = map.get(complement).get(0);
                    return res;
                }
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3};
		int target = 6;
		int[] res = twoSum(nums, target);

	}

}
