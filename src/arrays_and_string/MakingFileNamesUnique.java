package arrays_and_string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingFileNamesUnique {
	public static String[] getFolderNames(String[] names) {
		HashMap<String, Integer> map = new HashMap<>();

	    String res[] = new String[names.length];

	    for(int i = 0; i < names.length; i++) {
	        if(map.containsKey(names[i])) {
	            Integer val = map.get(names[i]);
	            StringBuilder sb = new StringBuilder(names[i]);
	            sb.append('(');
	            sb.append(val);
	            sb.append(')');
	            while (map.containsKey(sb.toString())) {
	                val++;
	                sb = new StringBuilder(names[i]);
	                sb.append('(');
	                sb.append(val);
	                sb.append(')');
	            }
	            res[i] = sb.toString();
	            map.put(sb.toString(), 1);
	            map.put(names[i], val + 1);
	        } else {
	            res[i] = names[i];
	            map.put(names[i], 1);
	        }
	    }
	    return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//                    gta, gta(1)
		// String[] input = {"gta","gta","avalon"};
		
		//                   gta, gta(1), gta(1)(1)
		String[] input = {"gta","gta", "gta(1)","avalon"}; 
		// need to store gta(1) in the map, in case there are more gta(1) in the input
		// map, key: file name, value: next index
		
		
		//                    gta, gta(1), gta(2)
		// String[] input = {"gta","gta(1)","gta","avalon"};
		

		String[] res = getFolderNames(input);
		System.out.println(1);

	}

}
