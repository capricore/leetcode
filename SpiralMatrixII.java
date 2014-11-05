import java.util.Arrays;


public class SpiralMatrixII
{
	public int[][] generateMatrix(int n)
	{
		int matrix[][] = new int [n][n];
		if (n == 0)
		{
			return matrix;
		}
		int beginX = 0, endX = n-1;
		int beginY = 0, endY = n-1;
		int insertNum = 0;
		while(true)
		{
			//from left to right
			for (int i = beginX; i <= endX; i++)
			{
				matrix[beginY][i] = ++insertNum;
			}
			if (++beginY > endY) break;
			//from top to bottom
			for (int i = beginY; i <= endY; i++)
			{
				matrix[i][endX] = ++insertNum;
			}
			if (beginX > --endX) break;
			//from right to left
			for (int i = endX; i >= beginX ; i--)
			{
				matrix[endY][i] = ++insertNum;
			}
			if(beginY > --endY) break;
			//from bottom to top
			for (int j = endY; j >= beginY; j--)
			{
				matrix[j][beginX] = ++insertNum;
			}
			if (++beginX > endX) break;
		}
		return matrix;
	}
	
	public static void main(String[] args)
	{
		SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
		int matrix[][] = new int[3][3];
		matrix = spiralMatrixII.generateMatrix(3);
		for (int[] is : matrix)
		{
			System.out.println(Arrays.asList(is));
			
		}
	}
}
