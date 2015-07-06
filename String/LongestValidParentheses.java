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
				if(stack.isEmpty()) left = i+1;//��¼�¸���Ч��Ե���ʼ����
				else{
					stack.pop();
					if(stack.isEmpty())//��Ч��ԵĿ�ʼλ����ջ�Ƿ�Ϊ�ն���
						maxLen = Math.max(maxLen, i-left+1);
					else//�ǿգ�����ȡ����ջ�����±�
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
