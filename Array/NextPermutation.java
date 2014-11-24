package Array;
import java.util.Arrays;


public class NextPermutation
{
	public void nextPermutation(int[] num)
	{
		int index = -1;
		if (num.length <= 1)
		{
			return;
		}
		for (int i = num.length-2; i >= 0; i--)
		{
			if (num[i] < num[i+1] )//必须是前者小于后者，不能加等号
			{
				index = i;
				break;
			}
		}
		if (index < 0)
		{
			reverse(-1, num);
			return;
		}
		for (int i = num.length-1; i > index; i--)
		{
			if (num[i] > num[index])//必须是大于num[index]，不能加等号
			{
				int temp = num[i];
				num[i] = num[index];
				num[index] = temp;
				break;
			}
		}
		reverse(index,num);
		return;
	}
	
	public void reverse(int index, int[] num)
	{
		for (int i = 1; i <= (num.length - index - 1)/2; i++)
		{
			int temp = num[index + i];
			num[index + i] = num[num.length -i];
			num[num.length - i] = temp;
		}
	}
	
	public static void main(String[] args)
	{
		NextPermutation nextPermutation = new NextPermutation();
		int [] num =  {1,3,2};
		nextPermutation.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
}
