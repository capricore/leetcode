package Array;

public class RotateArray {
	public void rotate(int[] nums, int k){
		int len = nums.length, nowIndex = 0;
		int tmp1 = 0,tmp2 = nums[0];
		for (int i = 0,j = 0; i < len; i++) {
			tmp1 = tmp2;
			nowIndex = (k + nowIndex) % len;
			tmp2 = nums[nowIndex];
			nums[nowIndex] = tmp1;
			if (nowIndex == j && j < len - 1) {
				nowIndex = ++j;
				tmp2 = nums[nowIndex];
			}
		}
	}
}
