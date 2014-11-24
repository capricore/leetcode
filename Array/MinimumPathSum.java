package Array;

public class MinimumPathSum
{
	public int minPathSum(int[][] grid)
	{
		int row = grid.length;
		int column = grid[0].length;
		int result[] = new int[column];
		for (int i = 1; i < result.length; i++)
		{
			result[i] = Integer.MAX_VALUE;
		}
		//动规状态转移方程：f[i][j] = min(f[i][j-1],f[i-1][j]) + grid[i][j]
		for (int i = 0; i < row; i++)
		{
			result[0] += grid[i][0];
			for (int j = 1; j < column; j++)
			{
				result[j] = Math.min(result[j], result[j-1]) + grid[i][j];
			}
		}
		return result[column-1];
	}
	
	public static void main(String[] args)
	{
		MinimumPathSum minimumPathSum = new MinimumPathSum();
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(minimumPathSum.minPathSum(grid));
	}
}
