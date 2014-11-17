
public class RemoveDuplicatesfromSortedArrayII
{
	public int removeDuplicates(int[] A)
	{
		int index = 0;
		if (A.length <= 2)
		{
			return A.length;
		}
		A[index++] = A[0];
		A[index++] = A[1];
		for (int i = 2; i < A.length; i++)
		{
			if (A[i] != A[index-2])//不能写成A[i] != A[i-2]，因为index-2才是新的不同数字的首个序号
			{
				A[index++] = A[i];
			}
		}
		return index;
	}
	public static void main(String[] args)
	{
		RemoveDuplicatesfromSortedArrayII removeDuplicatesfromSortedArrayII = new RemoveDuplicatesfromSortedArrayII();
		int[] A = {1,1,1,2,2,3};
		System.out.println(removeDuplicatesfromSortedArrayII.removeDuplicates(A));
		for (int i : A)
		{
			System.out.println(i);
		}
	}
}
