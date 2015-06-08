package Array;

import java.util.Stack;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		int[][] height = new int[m][n];
		for (int i = 0; i < n; i++) {
			int h = 0;
			for (int j = 0; j < m; j++) {
				if (matrix[j][i] == '1') {
					h++;
				}else {
					h = 0;
				}
				height[j][i] = h;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		int max = Integer.MIN_VALUE;
		stack.add(-1);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int prev = stack.peek();
				if (prev < 0 || height[i][j] > height[i][prev]) {
					stack.add(j);
				}else {
					int z = stack.pop();
					max = Math.max(max, height[i][z]*(j-stack.peek()-1));
					j--;
				}
			}
			while (stack.peek() != -1) {
				int z = stack.pop();
				max = Math.max(max, height[i][z]*(n-stack.peek()-1));
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {{'0','0','0'},{'0','0','0'},{'0','0','0'},{'0','0','0'}};
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}
}
