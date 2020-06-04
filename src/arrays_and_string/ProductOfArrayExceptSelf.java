package arrays_and_string;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] productToTheRight = new int[l];
        int p_r = 1;
        for (int i = l - 1; i >= 0; i--){
            productToTheRight[i] = p_r;
            p_r *= nums[i];
        }
        
        int p_l = 1;
        for (int i = 0; i < l; i++){
            productToTheRight[i] *= p_l;
            p_l *= nums[i];
        }
        return productToTheRight;
    }
}
