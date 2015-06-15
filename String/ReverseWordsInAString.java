package String;

public class ReverseWordsInAString
{
	public String reverseWords(String s)
	{
		StringBuilder result = new StringBuilder();
		if (s.isEmpty())
		{
			return new String("");
		}
		for (int i = s.length() -1; i >= 0; )
		{
			while (i >= 0 && s.charAt(i) == ' ')
			{
				i--;
			}
			if (i < 0)
			{
				break;
			}
			StringBuilder word = new StringBuilder();
			while (i >= 0 && s.charAt(i) != ' ')
			{
				word.append(s.charAt(i--));
			}
			word.reverse();
			word = word.append(' ');
			result.append(word);
		}
		if(result.length() == 0) 
        {  
            return new String("");  
        }
		return new String(result.deleteCharAt(result.length()-1));  
	}
	
	public static void main(String[] args)
	{
		String string = "abc aa";
		ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();

		System.out.println(reverseWordsInAString.reverseWords(string));
	}
}
