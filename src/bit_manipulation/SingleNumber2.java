package bit_manipulation;

public class SingleNumber2 {
	public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int count = 0;
            for (int n : nums){
            	//                 compare 0
                if ((n & (1 << i)) != 0){
                    count += 1;
                }
            }
            // either 0 or 1
            res |= ((count % 3) << i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {2, 2, -3, 2};
		int res = singleNumber(input);
		System.out.println(res);
		

	}

}
