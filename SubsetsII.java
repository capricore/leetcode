import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class SubsetsII
{
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int s[])
	{
		Arrays.sort(s);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		dfs(s,path, 0, result);
		return result;
	}
	
	public void dfs(int s[], ArrayList<Integer> path, int index ,ArrayList<ArrayList<Integer>> result)
	{
		@SuppressWarnings("unchecked")
		ArrayList<Integer> array = (ArrayList<Integer>) path.clone();
		result.add(array);
		for (int i = index; i < s.length; i++)
		{
			if (i != index && s[i] == s[i-1])
				continue;
			path.add(s[i]);
			dfs(s, path, i+1, result);
			path.remove(path.size()-1);
		}
	}
	public static void main(String[] args)
	{
		SubsetsII set = new SubsetsII();
		int s[] = {1,2,2};
		ArrayList<ArrayList<Integer>> result = set.subsetsWithDup(s);
		for (Iterator<ArrayList<Integer>> iterator = result.iterator(); iterator.hasNext();)
		{
			ArrayList<Integer> arrayList = (ArrayList<Integer>) iterator.next();
			System.out.println(arrayList);
		}
	}
}
