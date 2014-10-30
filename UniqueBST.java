public class UniqueBST
{
	public int numTrees(int n){
		int answer  = 1;
		for (int i = 1; i <= n; i++)
		{
			answer = (answer*(4*i-2))/(i+1);
		}
		return answer;
	}
	public static void main(String[] args)
	{
		UniqueBST bst = new UniqueBST();
		System.out.println(bst.numTrees(3));
	}
}
