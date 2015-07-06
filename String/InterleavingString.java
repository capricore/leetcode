package String;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3 == null) return true;
		if(s1 == null || s2 == null) return false;
		if(s1.length()+s2.length() != s3.length()) return false;
		int i = 0, j = 0, k = 0;
		while(i < s1.length() || j < s2.length()){
			if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
				i++;
				k++;
			}else if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
				j++;
				k++;
			}else{
				return false;
			}
		}
		return true;	
	}
	
	public static void main(String[] args){
		System.out.print(new InterleavingString().isInterleave("aabcc","dbbca", "aadbbcbcac"));
	}
}
