
public class TrappingRainWater
{
	public int trap(int A[])
	{
		int n = A.length;
		int sum = 0;
		int maxLeft[] = new int[n];
		int maxRight[] = new int[n];
		for (int i = 1; i < n; i++)
		{
			maxLeft[i] = max(maxLeft[i-1],A[i-1]);
			maxRight[n-1-i] = max(maxRight[n-i],A[n-i]);
		}
		
		for (int i = 0; i < maxRight.length; i++)
		{
			int height = min(maxLeft[i],maxRight[i]);
			if (height > A[i])
			{
				sum += height - A[i]; 
			}
		}
		return sum;
	}

	public int max(int x, int y)
	{
		return x > y ? x : y;
	}
	
	
	public int min(int x, int y)
	{
		return x > y ? y : x;
	}
	
	
	public static void main(String[] args)
	{
		TrappingRainWater water = new TrappingRainWater();
		int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(water.trap(A));
	}
}
