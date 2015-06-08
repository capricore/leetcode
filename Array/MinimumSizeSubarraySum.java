package Array;


public class MinimumSizeSubarraySum {
	
	public static  int minSubArrayLen(int s, int[] nums) {
		int count[] = new int[nums.length+1];
		int min = Integer.MAX_VALUE;
		count[0] = 0;
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i-1]+nums[i-1]; 
			for (int j = i-1; j >=0 ; j--) {
				if (count[i] - count[j] >= s) {
					if (i-j<min) {
						min = i-j;
					}
					break;
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = 0;
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}

}
