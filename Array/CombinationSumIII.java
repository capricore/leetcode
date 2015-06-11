package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		int[] candidates = {1,2,3,4,5,6,7,8,9};
		dfs(candidates, k, n , result, path, 0, 0);
		return result;
	}
	
	void dfs(int[] candidates, int k, int n, List<List<Integer>> result,  List<Integer> path, int cur, int index){
		if (path.size() > k || cur > n) {
			return;
		}
		if (path.size() == k && cur == n) {
			List<Integer> temp = new ArrayList<>(path);
			result.add(temp);
		}
		for (int i = index; i < candidates.length; i++) {
			cur += candidates[i];
			path.add(candidates[i]);
			dfs(candidates, k, n, result, path, cur, i+1);
			path.remove(path.size()-1);
			cur -= candidates[i];
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new CombinationSumIII().combinationSum3(3, 9));
	}

}
