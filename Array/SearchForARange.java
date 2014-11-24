package Array;

public class SearchForARange
{
	public int[] searchRange(int[] A, int target)
	{
		int result[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		find_bound(A,target,result,0,A.length-1);
		if (result[0] == Integer.MAX_VALUE)
		{
			result[0] = -1;
		}
		if (result[1] == Integer.MIN_VALUE)
		{
			result[1] = -1;
		}
		return result;
	}
	// 先用二分法找到满足条件，然后对两边分别二分法继续寻找
	public void find_bound(int A[],int target, int result[], int first ,int last)
	{
		if (first > last)
		{
			return;
		}
		int mid = (first+last)/2;
		if (A[mid] == target)
		{
			result[0] = Math.min(result[0], mid);//保存最小上限
			result[1] = Math.max(result[1], mid);//保存最大上限
			find_bound(A, target, result, first, mid-1);//继续找满足条件的下限
			find_bound(A, target, result, mid+1, last);//继续找满足条件的上限
		}else if(target < A[mid])
		{
			find_bound(A, target, result, first, mid-1);
		}else if(target > A[mid])
		{
			find_bound(A, target, result, mid+1, last);
		}
	}
}
