package String;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3 == null) return true;
		if(s1 == null || s2 == null) return false;
		if(s1.length()+s2.length() != s3.length()) return false;
		boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];//dp[i][j]��ʾs1[0,i-1]��s2[0,j-1]�Ƿ������s3[0,i+j-1];
		dp[0][0] = true;//�մ������ɿմ����
		for(int i = 0; i < s1.length()+1; i++)
			for(int j = 0;j < s2.length()+1; j++){
				//dp[i][j]Ϊ���������1.s1[i-1]����s3[i+j-1]����dp[i-1][j]Ϊ�棬2.s2[j-1]����s3[i+j-1]����dp[i][j-1]Ϊ��
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
