package Array;
public class MedianOfTwoSortedArrays
{
	public double findMedianSortedArrays(int[] A, int[] B)
	{
		int m = A.length;
		int n = B.length;
		int k = m + n;
		if (k % 2 == 1)
		{
			return findMedian(A, 0, m, B, 0, n, k / 2 + 1);// 找合并后序列的第k/2小的数，即中位数
		} else
		{
			double a = findMedian(A, 0, m, B, 0, n, k / 2 + 1);
			double b = findMedian(A, 0, m, B, 0, n, k / 2);
			return  (a+b)/2;
					
		}
	}

	public int findMedian(int[] A, int start_a, int m, int[] B, int start_b,int n, int k)
	{
		// image m always smaller or equal to n.
		if ((m - start_a) > (n - start_b))
		{
			return findMedian(B, start_b, n, A, start_a, m, k);
		}
		if (m == start_a)
		{
			return B[k - 1];
		}
		if (k == 1)
		{
			return Math.min(A[start_a], B[start_b]);
		}

		int index_a = Math.min(k / 2, m - start_a) + start_a, index_b = k - Math.min(k / 2, m - start_a) + start_b;
		if (A[index_a - 1] < B[index_b - 1])
		{
			return findMedian(A, index_a, m, B, start_b, n,	k - Math.min(k / 2, m - start_a));
		} else if (A[index_a - 1] > B[index_b - 1])
		{
			return findMedian(A, start_a, m, B, index_b, n,	Math.min(k / 2, m - start_a));
		} else
		{
			return A[index_a - 1];
		}
	}

	public static void main(String[] args)
	{
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		int[] A = { };
		int[] B = { 2,3};
		System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(A, B));
	}
}
