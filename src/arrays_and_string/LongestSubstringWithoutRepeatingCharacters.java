package arrays_and_string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	/*
    consecutive array -> sliding window
    use a map to record the last appearance index for occurred element
    */
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++){
            Character c = s.charAt(right);
            if (map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1);
            }
            res = Math.max(res, right - left + 1);
            map.put(c, right);
        }
        return res;
    }
}
