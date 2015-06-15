package String;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		if (numRows <= 1) {
			return s;
		}
		for (int i = 0; i < numRows; i++) {
			int j = i;
			while (j < len) {
				sb.append(s.charAt(j));
				if (i == 0 || i == numRows-1) {
					j += 2*numRows-2;
				}else {
					int index = j+2*numRows-(i+1)*2;
					if (index < len) {
						sb.append(s.charAt(index));
					}
					j += 2*numRows-2;
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "A";
		System.out.println(new ZigZagConversion().convert(s, 1));
	}
}
