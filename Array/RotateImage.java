package Array;


public class RotateImage
{
	public void rotate(int[][] matrix)
	{
		int n = matrix.length;
		int begin = 0, end = n-1;
		int temp = 0;
		while(true)
		{
			for (int i = 0; i < end-begin; i++)
			{
				temp = matrix[begin][begin+i];
				matrix[begin][begin+i] = matrix[end-i][begin]; 
				matrix[end-i][begin] = matrix[end][end-i];
				matrix[end][end-i] = matrix[begin+i][end];
				matrix[begin+i][end] = temp;
			}
			begin++;
			end--;
			if (begin >= end) break;
		}
	}
	
	public static void main(String[] args)
	{
		RotateImage rotateImage = new RotateImage();
		int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateImage.rotate(matrix);
		for (int[] is : matrix)
		{
			for (int i : is)
			{
				System.out.println(i);
			}
		}
	}
}
