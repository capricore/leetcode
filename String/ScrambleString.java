package String;

import java.util.Arrays;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int l1 = s1.length(), l2 = s2.length();
		if(l1 != l2) return false;
		if(s1.equals(s2)) return true;
		if(l1 == 1) return s1.equals(s2);
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String t1 = String.valueOf(c1);
		String t2 = String.valueOf(c2);
		if(!t1.equals(t2)) return false;
		for(int i = 1; i < l1; i++){
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, l1);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, l1);
			if(isScramble(s11,s21)&&isScramble(s12,s22)) return true;
			s21 = s2.substring(0, l1-i);
			s22 = s2.substring(l1-i, l1);
			if(isScramble(s11,s22)&&isScramble(s12,s21)) return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.print(new ScrambleString().isScramble("rgtae","great"));
	}
}
