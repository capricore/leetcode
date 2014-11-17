
public class SearchA2DMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		int row = matrix.length;
		int column = matrix[0].length;
		for (int i = 0; i < row; i++)
		{
			if (matrix[i][column-1] >= target)
			{
				for (int j = 0; j < column; j++)
				{
					if (matrix[i][j] == target)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
