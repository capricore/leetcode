package Array;

public class RemoveDuplicatesfromSortedArray
{
	public int removeDuplicates(int[] A)
	{
		int index = 0;
		if (A.length == 0)
		{
			return 0;
		}
		A[index++] = A[0]; 
		for (int i = 1; i < A.length; i++)
		{
			if (A[i] != A[i-1])
			{
				A[index++] = A[i];
			}
		}
		return index;
	}
	
	public static void main(String[] args)
	{
		RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
		int[] A = {1,1,2};
		System.out.println(removeDuplicatesfromSortedArray.removeDuplicates(A));
		for (int i : A)
		{
			System.out.println(i);
		}
	}
}
