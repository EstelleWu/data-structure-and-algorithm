package arrays_and_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// 1. SORT
public class ReorderDatainLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        // step1: divide into a list of letter-logs and a list of digit-logs
    	List<String> letterLogs = new ArrayList<>();
    	List<String> digitLogs = new ArrayList<>();
    	for (String s : logs) {
    		int indexOfFirstWord = s.indexOf(" ") + 1;
    		Character firstChar = s.charAt(indexOfFirstWord);
    		if (Character.isDigit(firstChar)) {
    			digitLogs.add(s);
    		}else {
    			letterLogs.add(s);
    		}
    	}
    	
    	
    	// step2: sort letterLogs
    	
    	// method1: anoymous func + inline
//    	Collections.sort(letterLogs, (a, b) -> (
//    			a.substring(a.indexOf(" ") + 1, a.length()).compareTo(b.substring(b.indexOf(" ") + 1, b.length())) == 0? 
//    					a.substring(0, a.indexOf(" ")).compareTo(b.substring(0, b.indexOf(" "))) : a.substring(a.indexOf(" ") + 1, a.length()).compareTo(b.substring(b.indexOf(" ") + 1, b.length()))));
    	
    	// method2: anoymous func
//    	Collections.sort(letterLogs, (a, b) -> {
//    		int indexOfFirstCharOfA = a.indexOf(" ") + 1;
//    		int indexOfFirstCharOfB = b.indexOf(" ") + 1;
//    		int afterIdentifierCompare = a.substring(indexOfFirstCharOfA, a.length()).compareTo(b.substring(indexOfFirstCharOfB, b.length()));
//    		if (afterIdentifierCompare != 0) {
//    			return afterIdentifierCompare;
//    		}else {
//    			int beforeIdentifierCompare = a.substring(0, indexOfFirstCharOfA).compareTo(b.substring(0, indexOfFirstCharOfB));
//    			return beforeIdentifierCompare;
//    		}
//    	});
    	
    	// method3: comparator
    	class CustomComparator implements Comparator<String>{
			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
	    		int indexOfFirstCharOfA = a.indexOf(" ") + 1;
	    		int indexOfFirstCharOfB = b.indexOf(" ") + 1;
	    		int afterIdentifierCompare = a.substring(indexOfFirstCharOfA, a.length()).compareTo(b.substring(indexOfFirstCharOfB, b.length()));
	    		if (afterIdentifierCompare != 0) {
	    			return afterIdentifierCompare;
	    		}else {
	    			int beforeIdentifierCompare = a.substring(0, indexOfFirstCharOfA).compareTo(b.substring(0, indexOfFirstCharOfB));
	    			return beforeIdentifierCompare;
	    		}
			}
    	}
    	Collections.sort(letterLogs, new CustomComparator());
    	
    	// step3: construct the result
    	String[] res = new String[logs.length];
    	int i = 0;
    	for (String s : letterLogs) {
    		res[i] = s;
    		i++;
    	}
    	for (String s : digitLogs) {
    		res[i] = s;
    		i++;
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
