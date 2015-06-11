package Array;

import java.util.HashMap;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> hashtable = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashtable.containsKey(nums[i])) {
				int j = hashtable.get(nums[i]);
				if (i - j <= k) {
					return true;
				}
			}
			hashtable.put(nums[i], i);
		}
		return false;
	}
}
