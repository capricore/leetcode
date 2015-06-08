package Array;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i])) {
				continue;
			}
			hashMap.put(nums[i], 1);
			if (hashMap.containsKey(nums[i]-1)) {
				max = Math.max(max, merge(hashMap,nums[i]-1,nums[i]));
			}
			if (hashMap.containsKey(nums[i]+1)) {
				max = Math.max(max, merge(hashMap,nums[i],nums[i]+1));
			}
		}
		return max;
	}
	
	int merge(HashMap<Integer, Integer> hashMap, int left, int right){
		int upper = right+hashMap.get(right)-1;
		int lower = left-hashMap.get(left)+1;
		int len = upper-lower+1;
		hashMap.put(upper, len);
		hashMap.put(lower, len);
		return len;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
	}

}
