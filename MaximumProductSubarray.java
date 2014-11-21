
public class MaximumProductSubarray
{
	
/*	Analysis:
 
	similar like Maximum Subarray question

	difference is the max value could be get from 3 situations

	current maxValue * A[i]  if A[i]>0

	current minValue * A[i]  if A[i]<0

	A[i]  

	We need to record current maxValue, current minValue and update them every time get the new product*/
	public int maxProduct(int[] A)
	{
		int product = A[0] ;
		int max = A[0];
		int min = A[0];
		for (int i = 1; i < A.length; i++)
		{
			int a = Math.min(min*A[i],max*A[i]);//a表示乘以A[i]后，当前的最小值，
			int b = Math.max(min*A[i],max*A[i]);//b表示乘以A[i]后，当前的最大值
			min = Math.min(A[i], a);//如果current_min大于-，表明A[i]>0，则此时局部最小取A[i]，即current_min
			max = Math.max(A[i], b);//如果current_max小于0，表明A[i]<0，则此时局部最大取A[i]，即current_max
			product = Math.max(product, max);//全局最大值
		}
		return product;
	}
	
	public static void main(String[] args)
	{
		MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
		int A[] = {-4,-3,-2};
		System.out.println(maximumProductSubarray.maxProduct(A));
	}
	
}
