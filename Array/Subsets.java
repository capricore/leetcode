package Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Subsets
{
	public ArrayList<ArrayList<Integer>> subsets(int s[])
	{
		Arrays.sort(s);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		subsets(s,path, 0, result);
		return result;
	}
	
	public void subsets(int s[], ArrayList<Integer> path, int index ,ArrayList<ArrayList<Integer>> result)
	{
		if(s.length == index)
		{
			@SuppressWarnings("unchecked")
			ArrayList<Integer> array = (ArrayList<Integer>) path.clone();
			result.add(array);
			return;
		}
		//不选择当前数
		subsets(s, path, index+1, result);
		//选择当前数
		path.add(s[index]);
		subsets(s, path, index+1, result);
		path.remove(path.size()-1);
	}
	public static void main(String[] args)
	{
		Subsets set = new Subsets();
		int s[] = {4,1,0};
		ArrayList<ArrayList<Integer>> result = set.subsets(s);
		for (Iterator<ArrayList<Integer>> iterator = result.iterator(); iterator.hasNext();)
		{
			ArrayList<Integer> arrayList = (ArrayList<Integer>) iterator.next();
			System.out.println(arrayList);
		}
	}
}
