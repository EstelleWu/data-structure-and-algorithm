package arrays_and_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class RemoveKDigits {
	
	public static String removeKdigits(String num, int k) {
		if (k == num.length()) {
			return "0";
		}
		List<Integer> numList = converStringToList(num);
		
		// monotonic stack
		// to pop the last few numbers
		numList.add(0);
		Stack<Integer> resStack = new Stack<>();
		resStack.add(numList.get(0));
		for (int i = 1; i < numList.size(); i++) {
			while (k > 0 && resStack.size() > 0 && resStack.peek() > numList.get(i)) {
				resStack.pop();
				k--;
			}
			resStack.push(numList.get(i));
		}
		resStack.pop();
		String res = convertStackToString(resStack);
		return res;
		
	}

	private static String convertStackToString(Stack<Integer> s) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<>(s);
		// remove leading zeros
		int firstIndex = 0;
		while (firstIndex < l.size()) {
			if (l.get(firstIndex) == 0) {
				firstIndex++;
			}else {
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = firstIndex; i < l.size(); i++) {
			sb.append(Integer.toString(l.get(i)));
		}
		return sb.toString();
	}
	
	private static List<Integer> converStringToList(String num) {
		// TODO Auto-generated method stub
		if (num == null || num.length() == 0) {
			return null;
		}
		
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < num.length(); i++) {
			res.add(num.charAt(i) - '0');
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String res = removeKdigits("5337", 2);

		System.out.println(res);

	}

}
