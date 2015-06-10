package Array;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				if (nums[i] <= 0 || nums[i] > len || nums[nums[i]-1] == nums[i]) {
					continue;
				}
				swap(nums, i, nums[i]-1);
				i--;
			}
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i+1) {
				result = i+1;
				break;
			}
		}
		if (result == 0) {
			result = len+1;
		}
		return result;
	}
	
	void swap(int[] nums, int start, int end){
		int i = nums[start];
		nums[start] = nums[end];
		nums[end] = i;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
	}

}
