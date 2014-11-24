package Array;

public class UniquePaths
{
	public int uniquePaths(int m, int n)
	{
		//状态转移方程：visited[i][j] = visited[i-1][j] + visited[i][j-1]
		//visited[i][j]表示从（1，1）到（i，j）的路线条数
		int visited[] = new int[n];
		visited[0] = 1;
		for (int i = 0; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				//左边的visited[j]，表示更新后的visited[j]，与公式中的visited[i][j]对应
				//右边的visited[j]，表示老的visited[j]，与公式中的visited[i-1][j]对应
				visited[j] = visited[j-1] + visited[j];
			}
		}
		return visited[n-1];
	}
	
	public static void main(String[] args)
	{
		UniquePaths paths = new UniquePaths();
		System.out.println(paths.uniquePaths(3, 2));
	}
}
