package arrays_and_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	// use alphabet array to encode for each string
	public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }            
            // method1: String key = Arrays.toString(counts); // return a string 
            
            // method2
            StringBuilder sb = new StringBuilder(""); // string builder is mutable
            for (int i = 0; i < 26; i++){
                sb.append("#");
                sb.append(counts[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(input);
		System.out.println(res);

	}

}
