package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 16 mins
class LinkedListCycleSolution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow){
        		return true;
        	}
        }
        return false;
    }
}

public class LinkedListCycle{
	public static void main(String args[]){
		LinkedListCycleSolution obj = new LinkedListCycleSolution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = null;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l1;
		System.out.println(obj.hasCycle(l5));
	}
}