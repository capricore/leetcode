package Array;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if (Math.abs(sum-target) == 0) {
					return sum;
				}
				if (Math.abs(sum-target) < min) {
					min = Math.abs(sum-target);
					result = sum;
				}
				if (left != right-1) {
					int sumleft = nums[left+1] + nums[right] + nums[i];
					int sumright = nums[left] + nums[right-1] + nums[i];
					if (Math.abs(sumleft-target) < Math.abs(sumright-target)) {
						left++;
					}else {
						right--;
					}
				}else {
					break;
				}
			}
		}
		return result;
	}
}
