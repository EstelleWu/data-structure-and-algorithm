package sorting_and_searching;

public class KthLargestElementInAnArray {
	public static int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int index = low;
        for (int i = low; i < high; i++){
            if (nums[i] < pivot){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        int temp = nums[index];
        nums[index] = pivot;
        nums[high] = temp;
        return index;
    }
    
    // output: the kth largest element
    public static int quickSelect(int[] nums, int low, int high, int target){
        if (low == high){
            return nums[low];
        }
        int pivotIndex = partition(nums, low, high);
        if (pivotIndex == target){
            return nums[pivotIndex];
        }else if (target < pivotIndex){
            return quickSelect(nums, low, pivotIndex - 1, target);
        }else{
            return quickSelect(nums, pivotIndex + 1, high, target);
        }
    }
    
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		int res = findKthLargest(nums, k);
		System.out.println(res);
	}

}
