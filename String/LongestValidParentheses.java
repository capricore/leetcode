package String;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if(s.length() < 2) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0, left = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '(') stack.add(i);
			else{
				if(stack.isEmpty()) left = i+1;//记录下个有效配对的起始坐标
				else{
					stack.pop();
					if(stack.isEmpty())//有效配对的开始位置视栈是否为空而定
						maxLen = Math.max(maxLen, i-left+1);
					else//非空，长度取决于栈顶的下标
						maxLen = Math.max(maxLen, i-stack.peek());
				}
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		System.out.print(new LongestValidParentheses().longestValidParentheses("(()))"));
	}
}
