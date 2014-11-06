
public class SortColors
{
	public void sortColors(int[] A)
	{
		int n = A.length;
		int red = 0, blue = n-1;
		for (int i = 0; i < blue + 1;)
		{
			if (A[i] == 0)
			{
				swap(A,i++,red++);
			}else if(A[i] == 2){
				swap(A,i,blue--);
			}else {
				i++;
			}
		}
	}
	
	public void swap(int A[],int x, int y)
	{
		int temp;
		temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
	
	public static void main(String[] args)
	{
		SortColors sortColors = new SortColors();
		int a[] = {0,0,1,2,1};
		sortColors.sortColors(a);
		for (int i : a)
		{
			System.out.println(i);
		}
		
	}
}
