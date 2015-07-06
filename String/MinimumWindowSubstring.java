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
				count++;//countֻ���¼��Ч���ַ������������ڴﵽt.length()֮�󲻻��ٸı䣬ֻ����Ϊ�޸�start���������
			}
			if (count == t.length()) {
				char ch = s.charAt(start);
				while(hasFind.containsKey(ch) == false || hasFind.get(ch) > toFind.get(ch)){//ֻ�г�ʼ�ַ�����������ҵ��ַ������Ѿ��ҵ����ַ�������������ַ���ʱ�Ż��޸�start
					if(hasFind.containsKey(ch)){
						hasFind.put(ch,hasFind.get(ch)-1);//���ص��ļ����Ѿ����ҵ��ַ�����Ӱ��������Ϊ�������ѭ�������ض��ܵ��ַ���count�Ѿ��ﵽҪ����ĳЩ�ַ����������Ѿ���������Ҫ���ҵ��ַ���
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
