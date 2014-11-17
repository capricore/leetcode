import java.util.Arrays;



public class PlusOne
{
	public int[] plusOne(int[] digits)
	{
		boolean overflow = false;
		int length = digits.length;
		for (int i = length-1; i >= 0; i--)
		{
			if (digits[i]+1 == 10)
			{
				overflow = true;
				digits[i] = 0;
			}else {
				digits[i] = digits[i] + 1;
				return digits;
			}
		}
		
		if (overflow)
		{
			int newdigits[] = new int[length + 1];
			System.arraycopy(digits, 0, newdigits, 1, length);//java复制数组的方法System.arraycopy(当位置跟origin不一样的时候，如果单纯的复制，用Arrays.copyOf())
			newdigits[0] = 1;	
			return newdigits;
		}
		return digits;
	}
}
