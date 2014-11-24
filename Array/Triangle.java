package Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Triangle
{
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
	{
		int m = triangle.size();
		for (int i = m-2; i >= 0; i--)
		{
			
			for (int j = 0; j < triangle.get(i).size(); j++)
			{
				int x = triangle.get(i+1).get(j);
				int y = triangle.get(i+1).get(j+1);
				int value = min(x, y) + triangle.get(i).get(j);
				triangle.get(i).set(j, value);
			}
			
		}
		return triangle.get(0).get(0);
	}
	
	public int min (int x, int y)
	{
		return x > y ? y : x;
	}
	
	public static void main(String[] args)
	{
		Triangle tri = new Triangle();
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
		for (ArrayList<Integer> arrayList : triangle)
		{
			System.out.println(arrayList);
		}
		System.out.println(tri.minimumTotal(triangle));
		for (ArrayList<Integer> arrayList : triangle)
		{
			System.out.println(arrayList);
		}
	}
}
