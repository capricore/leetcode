package Array;


public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int max = 0, left = 0, right = height.length-1;
		while (left < right) {
			max = Math.max(max, (right-left)*Math.min(height[left], height[right]));
			if (height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] height = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}
}
