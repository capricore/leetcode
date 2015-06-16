package String;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() < 2)
			return false;
		HashMap<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ')' && c != ']' && c != '}') {
				stack.add(c);
			} else {
				if (stack.isEmpty() || map.get(c) != stack.peek()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "((";
		System.out.println(new ValidParentheses().isValid(s));
	}
}
