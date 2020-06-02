package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
	public static Map<Character, Integer> counter(String s){
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }
    public static boolean anagram(Map<Character, Integer> map){
        for (int n : map.values()){
            if (n != 0){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> cur = counter(p);
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            Character c = s.charAt(right);
            if (!cur.containsKey(c)){
                left = right + 1;
                cur = counter(p);
            }else{
                if (cur.get(c) > 0){
                    cur.put(c, cur.get(c) - 1);
                    if (anagram(cur)){
                        res.add(left);
                        cur.put(s.charAt(left), cur.get(s.charAt(left)) + 1);
                        left++;
                    }
                }else{
                    while (s.charAt(left) != c){
                    	cur.put(s.charAt(left), cur.get(s.charAt(left)) + 1);
                        left++;
                    }
                    left++;
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaacbabc";
		String p = "abc";
		List<Integer> res = findAnagrams(s, p);
		System.out.println(res);
	}

}
