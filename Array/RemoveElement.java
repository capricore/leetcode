package Array;


public class RemoveElement
{
	public int removeElement(int[] A, int elem)
	{
		int end = A.length-1;
		for (int i = 0; i < end+1; i++)
		{
			if (A[i] == elem)
			{
				int temp = A[i];
				A[i--] = A[end];
				A[end--] = temp;
			}
		}
		return end+1;
	}
	public static void main(String[] args)
	{
		RemoveElement removeElement = new RemoveElement();
		int  A[] = {1};
		System.out.println(removeElement.removeElement(A, 1));
		for (int i : A)
		{
			System.out.println(i);
		}
	}
}
