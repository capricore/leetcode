package String;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (p.replace("*", "").length() > s.length())
	        return false;
	    boolean[] d = new boolean[s.length() + 1];
	    d[0] = true;
	    for (int i = 1; i < s.length(); ++i) {
	        d[i] = false;
	    }
	    for (int i = 1; i <= p.length(); ++i) {
	        char pchar = p.charAt(i - 1);
	        if (pchar == '*') {
	            for (int j = 1; j <= s.length(); ++j) {
	                d[j] = d[j - 1] || d[j];
	            }
	        }
	        else {
	            for (int j = s.length(); j >= 1; --j) {
	                d[j] = d[j - 1] && (pchar == '?' || pchar == s.charAt(j - 1));
	            }
	        }
	        d[0] = d[0] && pchar == '*';
	    }
	    return d[s.length()];
	}
	
	
	public static void main(String[] args) {
		String s = "aab";
		String p = "aa*";
		System.out.println(new WildcardMatching().isMatch(s, p));
	}
}
