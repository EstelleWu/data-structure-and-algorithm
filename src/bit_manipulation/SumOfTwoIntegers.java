package bit_manipulation;

public class SumOfTwoIntegers {
	public static int getSum(int a, int b) {
		while (b != 0) {
			int c = a & b;    
			a = a ^ b;
			b = c << 1;
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s = getSum(3, 5);
		System.out.println(s);

	}

}
