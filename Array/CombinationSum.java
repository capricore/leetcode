package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, result, path, 0, 0);
		return result;
	}
	
	void dfs(int[] candidates, int target, List<List<Integer>> result,  List<Integer> path, int cur, int index){
		if (cur > target) {
			return;
		}
		if (cur == target) {
			List<Integer> temp = new ArrayList<>(path);
			result.add(temp);
		}
		for (int i = index; i < candidates.length; i++) {
			cur += candidates[i];
			path.add(candidates[i]);
			dfs(candidates, target, result, path, cur, i);
			path.remove(path.size()-1);
			cur -= candidates[i];
		}
	} 
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println(new CombinationSum().combinationSum(candidates, 7));
	}

}
