package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 11 mins
class MiddleOfLinkedListSolution {
    public ListNode middleNode(ListNode head) {
    	if(head == null){
    		return null;
    	}
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return slow;
    }
}

public class MiddleOfLinkedList{
	public static void main(String args[]){
		MiddleOfLinkedListSolution obj = new MiddleOfLinkedListSolution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(obj.middleNode(n1).val);
		System.out.println(obj.middleNode(n2).val);
		System.out.println(obj.middleNode(n3).val);
		System.out.println(obj.middleNode(n4).val);
		System.out.println(obj.middleNode(n5).val);
		System.out.println(obj.middleNode(null));
	}
}