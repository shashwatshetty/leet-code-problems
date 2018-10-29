package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 14 mins
class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
        ListNode n = head.next;
        head.next = null;
        while(n != null) {
        	ListNode t = n.next;
        	n.next = head;
        	head = n;
        	n = t;
        }
        return head;
    }
}

public class ReverseLinkedList {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ReverseLinkedListSolution obj = new ReverseLinkedListSolution();
		ListNode ans = obj.reverseList(l1);
		while(ans != null) {
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}