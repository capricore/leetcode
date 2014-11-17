import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalsTriangle
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0)
		{
			return result;
		}
		else {
			result.add(Arrays.asList(1));
		}
		dfs(1,numRows,result);
		return result;
	}
	
	public void dfs(int index, int numRows, List<List<Integer>> result)
	{
		if (index == numRows)
		{
			return;
		}
		List<Integer> newArray = new ArrayList<Integer>();
		List<Integer> oldArray = result.get(index-1);
		int num = result.get(index-1).size();
		for (int i = 0; i < num+1; i++)
		{
			if (i == 0 || i == num)
			{
				newArray.add(1);
			}else {
				newArray.add(oldArray.get(i)+oldArray.get(i-1));
			}
		}		
		result.add(newArray);
		dfs(++index, numRows, result);
	}
	
	public static void main(String[] args)
	{
		PascalsTriangle pascalsTriangle = new PascalsTriangle();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = pascalsTriangle.generate(5);
		for (List<Integer> list : result)
		{
			System.out.println(list);
		}
	}
}
