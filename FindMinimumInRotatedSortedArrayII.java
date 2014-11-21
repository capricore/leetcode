
public class FindMinimumInRotatedSortedArrayII
{
	public int findMin(int[] num)
	{
		int begin = 0;
		int end = num.length;
		int minimun = Integer.MAX_VALUE;
		while (begin != end)
		{
			int mid = (begin + end)/2;
			minimun = Math.min(minimun, num[mid]);
			if (num[begin] < num[mid])
			{
				minimun = Math.min(minimun, num[begin]);
				begin = mid + 1;
			}else if (num[begin] > num[mid])
			{
				end = mid; 
			}else if (num[begin] == num[mid])
			{
				begin ++;
			}
		}
		return minimun;
	}
	public static void main(String[] args)
	{
		FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
		int[] num = {4,5,6,0,1,1,1};
		System.out.println(findMinimumInRotatedSortedArrayII.findMin(num));
	}
}
