package Array;

import java.util.ArrayList;

public class LargestRectangleinHistogram {

	public int largestRectangleArea(int[] height) {
		ArrayList<Integer> list = new ArrayList<>(10000);
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			int h = i == height.length ? 0 : height[i];
			if (list.isEmpty() || h >= height[list.get(list.size()-1)]) {
				list.add(i);
			}else {
				int prev = list.remove(list.size()-1);
				max = Math.max(max, height[prev]*(list.isEmpty() ? i : i-list.get(list.size()-1)-1));
				i--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] height = {2,1,3};
		System.out.println(new LargestRectangleinHistogram().largestRectangleArea(height));
	}
}
