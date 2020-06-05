package arrays_and_string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidParentheses {
	/*
    monotonic stack
    assumption: there would only be (, ), [, ], {, }
    */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        Set<Character> openBrackets = new HashSet<>();
        openBrackets.add('(');
        openBrackets.add('[');
        openBrackets.add('{');
        Set<Character> closeBrackets = new HashSet<>();
        closeBrackets.add(')');
        closeBrackets.add(']');
        closeBrackets.add('}');
        
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (openBrackets.contains(c)){
                stack.addLast(c);
            }else{
                if (stack.size() <= 0){
                    return false;
                }else{
                    if (!match(stack.peekLast(), c)){
                        return false;
                    }else{
                        stack.pollLast();
                    }
                }
            }
        }
        return stack.size() == 0;
    }
    
    private Boolean match(Character c1, Character c2){
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        return map.get(c1) == c2;
    }
}
