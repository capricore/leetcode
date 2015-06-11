package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
			if (i != index && candidates[i] == candidates[i-1]) {
				continue;
			}
			cur += candidates[i];
			path.add(candidates[i]);
			dfs(candidates, target, result, path, cur, i+1);
			path.remove(path.size()-1);
			cur -= candidates[i];
		}
	} 
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		System.out.println(new CombinationSumII().combinationSum2(candidates, 8));
	}

}
