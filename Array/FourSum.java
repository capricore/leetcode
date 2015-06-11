package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int target3 = target - nums[i];
			for (int j = i+1; j < nums.length; j++) {
				int target2 = target3 - nums[j];
				int left = j+1;
				int right = nums.length-1;
				while (left < right) {
					int sum = nums[left] + nums[right];
					if (sum < target2) {
						left++;
					}else if (sum > target2) {
						right--;
					}else {
						List<Integer> path = new ArrayList<>();
						path.add(nums[i]);
						path.add(nums[j]);
						path.add(nums[left]);
						path.add(nums[right]);
						result.add(path);
						while (left < right && nums[left] == path.get(2)) ++left;
						while (left < right && nums[right] == path.get(3)) --right;
					}
				}
				while (j+1 < nums.length && nums[j+1] == nums[j]) ++j;
			}
			while (i+1 < nums.length && nums[i+1] == nums[i]) ++i;
		}
		return result;
	}
}
