package arrays_and_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * sort string
 * string -> char array -> sort char array -> sorted string
 * */
public class groupAnagrams1 {
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs){
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sorted_s = new String(tempArray);
            if (map.containsKey(sorted_s)){
                map.get(sorted_s).add(s);
            }else{
                List<String> string_list = new ArrayList<>();
                string_list.add(s);
                map.put(sorted_s, string_list);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
        
    }
}
