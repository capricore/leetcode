package String;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if(s.length() <= 1) return s;
		//construct a string to calculate the KMP next array, next[r.length()-1] represent the palindrome length start from s[0];
		StringBuilder r = new StringBuilder(s);
		r.append('#');
		StringBuilder reverse = new StringBuilder();
		for(int i = s.length()-1; i >= 0 ; i--){
			reverse.append(s.charAt(i));
		}
		r.append(reverse);
		
		int[] next = new int[r.length()];
		next[0] = -1;
		int i = 0, j= -1;
		while(i < r.length()-1){
			if(j == -1 || r.charAt(i) == r.charAt(j)){
				i++;
				j++;
				next[i] = j;
			}else{
				j = next[j];
			}
		}
		return reverse.toString().substring(0, s.length()-next[r.length()-1]-1)+s;
	}
	
	public static void main(String[] args){
		System.out.print(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
	}
}
