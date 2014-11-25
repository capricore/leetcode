class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
		next = null;
	}
}

public class SortList
{
	
	public ListNode sortList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}
		return mergeSort(head);
	}
	
	public ListNode mergeSort(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow;
		slow = slow.next;
		fast.next = null;
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(slow);
		return merge(left,right);
		
	}
	
	public ListNode merge(ListNode left, ListNode right)
	{
		ListNode head = new ListNode(-1);
		ListNode temp = head;
		while (left != null && right != null)
		{
			if (left.val < right.val)
			{
				temp.val = left.val;
				left = left.next;
			}else {
				temp.val= right.val;
				right = right.next;
			}
			temp.next = new ListNode(-1);
			temp = temp.next;
		}
		if (left == null)
		{
			temp.val = right.val;
			right = right.next;
			while (right != null)
			{
				temp.next = new ListNode(-1);
				temp = temp.next;
				temp.val = right.val;
				right = right.next;
			}
		}else {
			temp.val = left.val;
			left = left.next;
			while (left != null)
			{
				temp.next = new ListNode(-1);
				temp = temp.next;
				temp.val = left.val;
				left  = left.next;
			}
		}
		return head;
	}
	
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(5);
		SortList sortList = new SortList();
		head = sortList.sortList(head);
		while (head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
		
	}
}
