package String;

public class ValidNumber {
	 boolean parseChar(String s, String c){
		 char[] cset = c.toCharArray();
		 for (int i = 0; i < cset.length; i++) {
			if (pos < s.length() && cset[i] == s.charAt(pos)) {
				pos++;
				return true; 
			}
		}
		return false;
	 }

	boolean parseSpace(String s) {
		for (int i = pos; i <= s.length(); i++) {
			if (i == s.length()) {
				pos = i;
				return true;
			}
			if (pos< s.length() && s.charAt(i) != ' ') {
				pos = i;
				return true;
			}
		}
		return false;
	}

	boolean parseSign(String s) {
		if (pos < s.length() && (s.charAt(pos) == '-' || s.charAt(pos) == '+')) {
			pos++ ;
			return true;
		}
		return false;
	}

	boolean parseInt(String s) {
		if (parseChar(s, "0123456789")) {
			while (parseChar(s, "0123456789"));
			return true;
		}
		return false;
	}
	
	boolean parseDoc(String s){
		if (pos < s.length() && s.charAt(pos) == '.') {
			pos++ ;
			return true;
		}
		return false;
	}

	boolean parseReal(String s){
		boolean f1 = parseInt(s);
		boolean f2 = parseDoc(s);
		boolean f3 = parseInt(s);
		if (f1 || (f2 && f3)) {
			return true;
		}
		return false;
	}
	
	int pos = 0;
	public boolean isNumber(String s) {
		parseSpace(s);
		parseSign(s);
		if (!parseReal(s)) {
			return false;
		}
		if (parseChar(s, "eE")) {
			parseSign(s);
			if (!parseInt(s)) {
				return false;
			}
		}
		parseSpace(s);
		return pos == s.length();
	}
	
	public static void main(String[] args) {
		String s = "2e10";
		System.out.println(new ValidNumber().isNumber(s));
	}

}
