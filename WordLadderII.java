import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node
{
	int level;
	String value;
	LinkedList<Node> prev;

	public Node(int level, String value)
	{
		this.level = level;
		this.value = value;
	}

	void addPrev(Node node)
	{
		if (prev == null || prev.size() == 0)
		{
			prev = new LinkedList<Node>();
		}
		prev.add(node);
	}
}

public class WordLadderII
{
	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

	public void findPath(Node endNode, ArrayList<String> current, String start)
	{
		if (endNode.value.equals(start))
		{
			result.add(current);
			return;
		}

		ArrayList<String> tempList;
		for (Node node : endNode.prev)
		{
			tempList = new ArrayList<String>(current);
			tempList.add(0, node.value);
			findPath(node, tempList, start);
		}
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			Set<String> dict)
	{
		HashMap<String, Node> hashMap = new HashMap<String, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		Node node = new Node(0, start);
		queue.add(node);
		Node endNode = null;
		hashMap.put(start, node);
		boolean isFound = false;
		boolean flag = false;
		while (queue.size() > 0 && !isFound)
		{
			int queueLength = queue.size();
			for (int k = 0; k < queueLength; k++)
			{
				node = queue.poll();
				for (int i = 0; i < node.value.length(); i++)
				{
					StringBuilder word = new StringBuilder(node.value);
					for (char j = 'a'; j <= 'z'; j++)
					{
						word.setCharAt(i, j);
						if (word.toString().equals(end))
						{
							if (!flag)
							{
								Node temp = new Node(node.level + 1, word.toString());
								flag = true;
								temp.addPrev(node);
								endNode = temp;
								isFound = true;
							}else {
								endNode.addPrev(node);
								isFound = true;
							}							
						}
						if (dict.contains(word.toString()))
						{
							Node newNode = hashMap.get(word.toString());
							if (newNode == null)
							{
								Node addNode = new Node(node.level + 1,
										word.toString());
								addNode.addPrev(node);
								hashMap.put(word.toString(), addNode);
								queue.add(addNode);
							} else
							{
								if (newNode.level == node.level + 1)
								{
									newNode.addPrev(node);
								}
							}
						}
					}
				}
			}
		}
		if (endNode != null )
		{
			findPath(endNode, new ArrayList<String>(Arrays.asList(end)),
					start);
		}
		return result;
	}

	public static void main(String[] args)
	{
		WordLadderII wordLadderII = new WordLadderII();
		List<String> dictionary = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		Set<String> dict = new HashSet<>(dictionary);
		ArrayList<ArrayList<String>> ladder = wordLadderII.findLadders("hit",
				"cog", dict);
		for (ArrayList<String> arrayList : ladder)
		{
			System.out.println(arrayList);
		}
	}
}
