import java.util.ArrayList;
import java.util.List;


public class PascalsTriangleII
{
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> result = new ArrayList<Integer>();
		//非常巧妙的方法
		for (int i = 0; i <= rowIndex; i++)
		{
			for (int j = i-1; j > 0 ; j--)
			{
				result.set(j, result.get(j)+result.get(j-1));
			}
			result.add(1);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
		List<Integer> result = pascalsTriangleII.getRow(3);
		System.out.println(result);
	}
}
