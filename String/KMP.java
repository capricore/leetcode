package String;

public class KMP {
	int[] makeNext(String s) {//�Ż��㷨����next�����ֵ
		int len = s.length();
		int[] next = new int[len + 1];
		int j = -1, i = 0;
		next[0] = -1;
		while (i < len-1) {
			if (j == -1 || s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				if (s.charAt(i) != s.charAt(j)) // �������
					next[i] = j;
				else
					// ������������ＴΪ�Ż�֮����������AAAAB, ��ֹ4��A�γ�0123��ƥ��ʱ��ε�����
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
