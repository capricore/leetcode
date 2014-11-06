
public class SearchInsertPosition
{
	public int searchInsert(int[] A, int target)
	{
		int index = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] >= target )
			{
				index = i;
				break;				
			}
		}
		if (target > A[A.length-1])
		{
			return A.length;
		}
		return index;
	}
	public static void main(String[] args)
	{
		SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
		int a[] = {1,3,5,6}; 
		System.out.println(searchInsertPosition.searchInsert(a, 0));
	}
}
