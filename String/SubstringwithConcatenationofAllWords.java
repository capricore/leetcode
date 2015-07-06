package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(words.length == 0) return result;
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		for(int i=0 ; i<words.length; i++){
			if(!toFind.containsKey(words[i])){
				toFind.put(words[i], 1);
			}else{
				toFind.put(words[i], toFind.get(words[i])+1);
			}
		}
		int length = words.length * words[0].length();
		for(int i = 0; i< s.length() - length + 1; i++ ){
			String subString = s.substring(i, i+length);
			HashMap<String, Integer> temp = (HashMap<String, Integer>)toFind.clone();
			if(check(subString,temp,words)){
				result.add(i);
			}
		}
		return result;
	}
	
	boolean check(String s, HashMap<String, Integer> toFind, String[] words){
		int count = 0, wordLen = words[0].length();
		for(int i=0; i < s.length(); i+=wordLen){
			String word = s.substring(i, i+wordLen);
			if(toFind.containsKey(word)&&toFind.get(word)>0){
				count++;
				toFind.put(word, toFind.get(word)-1);
			}else{
				return false;
			}
		}
		return count == words.length;
	}
	
	public static void main(String[] args){
		String[] words = {"foo", "bar"};
		System.out.println(new SubstringwithConcatenationofAllWords().findSubstring("barfoothefoobarman", words));
	}
}
