

public class MergeSortedArray
{
	public void merge(int[] A, int m, int[] B, int n)
	{
		int i = m-1, j = n-1,k = m + n ;//从后面往前面填则避免了很多的移动
		while (i >= 0 && j >= 0)
		{
			A[--k] = A[i] > B[j] ? A[i--] :B[j--];
		}
		while(j >= 0)
		{
			A[--k] = B[j--];
		}
	}
}
