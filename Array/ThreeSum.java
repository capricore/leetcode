package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				break;
			}
			int target = 0 - nums[i];
			int left = i+1;
			int right = nums.length-1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum < target) {
					left++;
				}else if (sum > target) {
					right--;
				}else {
					List<Integer> path = new ArrayList<>();
					path.add(nums[i]);
					path.add(nums[left]);
					path.add(nums[right]);
					result.add(path);
					while (left < right && nums[left] == path.get(1)) ++left;
					while (left < right && nums[right] == path.get(2)) --right;
				}
			}
			while (i+1 < nums.length && nums[i+1] == nums[i]) ++i;
		}
		return result;
	}
}
