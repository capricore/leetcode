package Array;

public class SearchInRotatedSortedArray
{
	public int search(int[] A ,int target)
	{
		int begin = 0;
		int end = A.length;//end初值是数组的个数
		int middle = 0;		
		while(begin != end )
		{
			middle = (begin + end)/2;
			if (A[middle] == target)
			{
				return middle;
			}
			if (A[begin] <= A[middle])
			{
				if (A[begin] <= target && target < A[middle])//左边加等号是因为target可能等于A[begin]
				{
					end = middle;//这里不要写成middle-1，否则会找不到开始和最后的值
				}else {
					begin = middle + 1;
				}
			}else {
				if (A[middle] < target && target <= A[end-1])//右边加等号是因为target可能等于A[end-1]
				{
					begin = middle + 1;
				}else {
					end = middle;//这里不要写成middle-1，否则会找不到开始和最后的值
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
		int a[] = {1,2,3};
		System.out.println(searchInRotatedSortedArray.search(a, 1));
	}
}
