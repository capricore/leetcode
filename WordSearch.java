
public class WordSearch
{
	public boolean exist(char[][] board, String word)
	{
		int rank = board.length;
		int row = board[0].length;
		boolean visited[][] = new boolean[rank][row];
		for (int i = 0; i < rank; i++)
		{
			for (int j = 0; j < row; j++)
			{
				if (dfs(board,word,0,i,j,visited))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dfs(char board[][], String word, int index, int x, int y, boolean visited[][])
	{
		if (index == word.length())
		{
			return true;
		}
		if (x < 0 || y < 0 || y >= board[0].length || x >= board.length)
		{
			return false;
		}
		
		if (visited[x][y])
		{
			return false;
		}
		
		if (board[x][y] != word.charAt(index) )
		{
			return false;
		}
		
		visited[x][y] = true;
		boolean result = dfs(board, word, index+1, x+1, y, visited) ||
						 dfs(board, word, index+1, x, y+1, visited) ||
						 dfs(board, word, index+1, x-1, y, visited) ||
						 dfs(board, word, index+1, x, y-1, visited);
		visited[x][y] = false;
		return result;
	}
	
	public static void main(String[] args)
	{
		char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		WordSearch worldSearch = new WordSearch();
		System.out.println(worldSearch.exist(board, "ABCCED"));
		
	}
}
