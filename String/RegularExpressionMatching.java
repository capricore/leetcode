package String;

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(s == null) return p == null;
		if(p == null) return false;
		return isMatch(s,0,p,0);
	}
	
	boolean isMatch(String s, int i, String p, int j){
		if(j == p.length()) return i == s.length();
		if(j == p.length()-1 || p.charAt(j+1) != '*'){
			if(s.length() == i) return false;
			if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
				return isMatch(s, i+1, p, j+1);
			else 
				return false;
		}
		while(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j ) == '.')){
			if(isMatch(s,i,p,j+2)) return true;//跳过*符号，递归调用函数p+2和s
			i++;//不跳过*符号，继续匹配p和s+1
		}
		//s到头的情况，这时候需要跳过*,递归调用函数p+2和s
		return isMatch(s,i,p,j+2);
	}
	
	public static void main(String[] args){
		System.out.print(new RegularExpressionMatching().isMatch("aaab", "a*b*"));
	}
}
