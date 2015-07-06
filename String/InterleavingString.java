package String;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3 == null) return true;
		if(s1 == null || s2 == null) return false;
		if(s1.length()+s2.length() != s3.length()) return false;
		boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];//dp[i][j]表示s1[0,i-1]和s2[0,j-1]是否能组成s3[0,i+j-1];
		dp[0][0] = true;//空串可以由空串组成
		for(int i = 0; i < s1.length()+1; i++)
			for(int j = 0;j < s2.length()+1; j++){
				//dp[i][j]为真的条件是1.s1[i-1]等于s3[i+j-1]并且dp[i-1][j]为真，2.s2[j-1]等于s3[i+j-1]并且dp[i][j-1]为真
				if(dp[i][j] || (i > 0 && dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (j > 0 && dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)))
					dp[i][j] = true;
				else 
					dp[i][j] = false;
			}
		return dp[s1.length()][s2.length()];	
	}
	
	public static void main(String[] args){
		System.out.print(new InterleavingString().isInterleave("a","b", "a"));
	}
}
