package String;

public class KMP {
	int[] makeNext(String s) {//优化算法，求next数组的值
		int len = s.length();
		int[] next = new int[len + 1];
		int j = -1, i = 0;
		next[0] = -1;
		while (i < len-1) {
			if (j == -1 || s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				if (s.charAt(i) != s.charAt(j)) // 正常情况
					next[i] = j;
				else
					// 特殊情况，这里即为优化之处。考虑下AAAAB, 防止4个A形成0123在匹配时多次迭代。
					next[i] = next[j];
			} else {
				j = next[j];
			}
		}
		return next;
	}
	
	int[] getNext(String s) {
		int len = s.length();
		int[] next = new int[len + 1];
		int j = -1, i = 0;
		next[0] = -1;
		while (i < len-1) {
			if (j == -1 || s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	

	int kmp(String s, String d, int[] next) {
		int i = 0, n = 0, j = 0;
		while (i < s.length()) {
			if (j == -1 || s.charAt(i) == d.charAt(j)) {
				i++;
				j++;
				if (j == d.length()) {
					n++;
					j = next[j];
				}
			} else {
				j = next[j];
			
			}
		}
		return n;
	}

	public static void main(String[] args) {
		int[] next = new KMP().getNext("abac#caba");
		System.out.print(new KMP().kmp("AAACBAAACB", "AAACB",
				next));
	}
}
