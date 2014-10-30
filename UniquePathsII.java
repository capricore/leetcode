
public class UniquePathsII
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int dp[] = new int[n];
		dp[0] = obstacleGrid[0][0]>0 ? 0: 1;
		for (int i = 0; i < m; i++)
		{
			dp[0] = obstacleGrid[i][0] ==1 ? 0 : dp[0];
			for (int j = 1; j < n; j++)
			{
				if (obstacleGrid[i][j] ==1)
				{
					dp[j] = 0;
				}else {
					dp[j] +=dp[j-1]; 
				}
			}
		}
		return dp[n-1];
	}
	
	
	public static void main(String[] args)
	{
		UniquePathsII uniquePathsII = new UniquePathsII();
		int obstacleGrid[][] = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid));
	}
}
