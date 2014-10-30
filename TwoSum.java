import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSum
{
	public int[] twoSum(int[] numbers, int target)
	{
		Map<Integer, Integer> process = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < numbers.length; i++)
		{
			int numToFind = target - numbers[i];
			if (process.containsKey(numToFind))
			{
				result.add(process.get(numToFind));
				result.add(i);
			}
			process.put(numbers[i], i);
		}
		int re[] = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
		{
			re[i] = result.get(i).intValue() + 1;
		}
		return re;
	}
	public static void main(String[] args)
	{
		TwoSum toSum = new TwoSum();
		int numbers[] = {2,7,13,43};
		int result[] = toSum.twoSum(numbers, 9);
		for (int i = 0; i < result.length; i++)
		{
			System.out.println(result[i]+1);
		}
		
	}
}
