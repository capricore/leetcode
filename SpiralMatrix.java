import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix
{
	public List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> result = new ArrayList<>();
		int m = matrix.length;
		if (m == 0)
		{
			return result;
		}
		int n = matrix[0].length;		
		int beginX = 0, endX = n-1;
		int beginY = 0, endY = m-1;
		while(true)
		{
			//from left to right
			for (int i = beginX; i <= endX; i++)
			{
				result.add(matrix[beginY][i]);
			}
			if (++beginY > endY) break;
			//from top to bottom
			for (int i = beginY; i <= endY; i++)
			{
				result.add(matrix[i][endX]);
			}
			if (beginX > --endX) break;
			//from right to left
			for (int i = endX; i >= beginX ; i--)
			{
				result.add(matrix[endY][i]);
			}
			if(beginY > --endY) break;
			//from bottom to top
			for (int j = endY; j >= beginY; j--)
			{
				result.add(matrix[j][beginX]);
			}
			if (++beginX > endX) break;
			
		}
		return result;
	}
	
	
	public static void main(String[] args)
	{
		int matrix[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		List<Integer> result = spiralMatrix.spiralOrder(matrix);
		System.out.println(result);
	}
}
