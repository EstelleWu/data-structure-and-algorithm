package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	/*
    need to know all the combination -> backtracking
    map to store the mapping between integer and alphabet
    */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r', 's'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        // input: index, digits, map, currentRes, res
        List<String> res = new ArrayList<>();
        StringBuilder curRes = new StringBuilder();
        backtracking(0, digits, map, curRes, res);
        return res;  
    }
    
    private void backtracking(int index, String digits, Map<Character, char[]> map, StringBuilder curRes, List<String> res){
        if (index == digits.length()){
            res.add(curRes.toString());
            return;
        }
        for (char c : map.get(digits.charAt(index))){
            curRes.append(c);
            backtracking(index + 1, digits, map, curRes, res);
            curRes.deleteCharAt(curRes.length() - 1);
        }
    }
}
