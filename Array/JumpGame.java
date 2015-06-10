package Array;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return false;
		}
		int max = 0, len = nums.length-1;
		for (int i = 0; i < nums.length; i++) {
			if (max < i) {
				return false;
			}else {
				if (nums[i] + i >= len) {
					return true;
				}else if (nums[i] + i > max) {
					max = nums[i] + i;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,0,4};
		System.out.println(new JumpGame().canJump(nums));
	}
}
