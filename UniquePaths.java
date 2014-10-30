
public class UniquePaths
{
	public int uniquePaths(int m, int n)
	{
		int visited[] = new int[n];
		visited[0] = 1;
		for (int i = 0; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
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
