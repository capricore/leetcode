package Array;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (max < sum) {
				max = sum;
			}
			if (max < nums[i]) {
				max = nums[i];
				sum = nums[i];
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new MaximumSubarray().maxSubArray(nums));
	}
}
