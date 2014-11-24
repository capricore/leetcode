import java.util.Stack;

public class EvaluateReversePolishNotation
{
	public int evalRPN(String[] tokens)
	{
		int returnValue = 0;
		String operators = "+-*/";

		Stack<String> stack = new Stack<String>();

		for (String t : tokens)
		{
			if (!operators.contains(t))
			{
				stack.push(t);
			} else
			{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (t)
				{
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
		returnValue = Integer.valueOf(stack.pop());

		return returnValue;
	}

	public static void main(String[] args)
	{
		EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
		String[] strings = { "0", "3", "/" };
		System.out.println(evaluateReversePolishNotation.evalRPN(strings));
	}
}
