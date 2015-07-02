package String;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		if (words.length ==  0) {
			return result;
		}
		int first = 0, last = 0, len = 0, spaceCount = 0;
		boolean newLine = true;
		for (int i = 0; i < words.length; i++) {
			if (newLine) {
				len += words[i].length();
				newLine = false;
			}else {
				len += words[i].length();
			}
			spaceCount++;
			if (len + spaceCount - 1 > maxWidth) {
				last = i-1;
				if (last - first <2) {
					result.add(spaceAdd(words,first,maxWidth));
				}else {
					result.add(generate(words, first, last, len-words[i].length(), maxWidth, false));
				}
				first = i;
				i--;
				len = 0;
				newLine = true;
				spaceCount = 0;
			}
		}
		last = words.length-1;
		if (last == first) {
			result.add(spaceAdd(words,first,maxWidth));
		}else {
			result.add(generate(words, first, last, len , maxWidth, true));	
		}
		return result;
	}
	
	String generate(String[] words, int first, int last, int wordLen, int maxWidth, boolean isLast){
		StringBuilder s = new StringBuilder();
		int freeSpace = maxWidth - wordLen;
		int spaceAve = freeSpace/(last-first);
		s.append(words[first]);
		for (int i = 1; i <= last - first; i++) {
			if (!isLast) {
				for (int j = 0; j < spaceAve; j++) {
					s.append(' ');
				}
			}
			if (isLast || (!isLast && (i-1) < freeSpace%(last-first)) ) {
				s.append(' ');
			}
			s.append(words[i+first]);
		}
		if (isLast) {
			int length = s.length();
			for (int i = 0; i < maxWidth - length; i++) {
				s.append(' ');
			}
		}
		return s.toString();
	}
	
	String spaceAdd(String[] words, int first, int maxWidth){
		StringBuilder s = new StringBuilder();
		s.append(words[first]);
		for (int i = s.length(); i < maxWidth; i++) {
			s.append(' ');
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		String[] words = {"What","must","be","shall","be."};
		System.out.println(new TextJustification().fullJustify(words, 12));
	}
}
