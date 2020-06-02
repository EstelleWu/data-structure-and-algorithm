package bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber3 {
	public static void singleNumber3(int[] nums) {
		//1d
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		int[] int_arr = new int[2];
		// not applicable for the arguments (int[])????
		// int_arr = list1.toArray(int_arr);
		
		Integer[] integer_arr = new Integer[2];
		integer_arr = list1.toArray(integer_arr);
	
		
		//2d
		List<String[]> list = new ArrayList<>();
		String[] sa_1 = {"a", "b"};
		String[] sa_2 = {"c", "d"};
		list.add(sa_1);
		list.add(sa_2);
		// toArray() return Object[], toArray(T[] a) return T[]
		//version1
		//String[][] res = list.toArray();
		//version2
		String[][] matrix = new String[list.size()][];
		matrix = list.toArray(matrix);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
