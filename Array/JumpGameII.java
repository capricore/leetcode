package Array;

public class JumpGameII {
	public int jump(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int max = 0, count = 0, next = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > max) {
				max = next;
				count++;
			}
			next = Math.max(next, i+nums[i]);
		}
		return count;
	}

}
