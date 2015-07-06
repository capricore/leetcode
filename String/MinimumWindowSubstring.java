package String;

import java.util.HashMap;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		String result = new String();
		if (t == null || s == null)
			return result;
		HashMap<Character, Integer> toFind = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (toFind.containsKey(c)) {
				toFind.put(c, toFind.get(c) + 1);
			} else {
				toFind.put(c, 1);
			}
		}
		int count = 0, start = 0, minLen = s.length()+1, minStart = 0;
		HashMap<Character, Integer> hasFind = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!toFind.containsKey(c))
				continue;
			if (hasFind.containsKey(c)) {
				hasFind.put(c, hasFind.get(c) + 1);
			} else {
				hasFind.put(c, 1);
			}
			if(hasFind.get(c) <= toFind.get(c)){
				count++;//count只会记录有效的字符数量，并且在达到t.length()之后不会再改变，只会作为修改start的入口条件
			}
			if (count == t.length()) {
				char ch = s.charAt(start);
				while(hasFind.containsKey(ch) == false || hasFind.get(ch) > toFind.get(ch)){//只有初始字符不是所需查找的字符或者已经找到的字符数大于所需的字符数时才会修改start
					if(hasFind.containsKey(ch)){
						hasFind.put(ch,hasFind.get(ch)-1);//不必担心减少已经查找的字符数会影响结果，因为进到这个循环里来必定总的字符数count已经达到要求并且某些字符数的数量已经超出所需要查找的字符数
					}
					start++;
					ch = s.charAt(start);
				}
				int len = i -start + 1;
				if(len < minLen){
					minLen = len;
					minStart = start;
				}
			}
		}
		if(minLen <= s.length()){
			result = s.substring(minStart, minStart+minLen);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.print(new MinimumWindowSubstring().minWindow(
				"ADOBECODEBANC", "ABC"));
	}
}
