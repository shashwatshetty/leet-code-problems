package mediumproblems;

// Took 3 attempts
// Time Taken To Solve: 98 mins
class RemoveDuplicateListIISolution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null, prev = null;
        ListNode curr = head;
        ListNode x = curr;
        int count = 1;
        while(curr != null) {
        	while(x.next != null && x.next.val == curr.val) {
        		count++;
        		x = x.next;
        	}
        	if(count == 1) {
        		if(newHead == null) {
        			newHead = x;
        			prev = newHead;
        		}else {
        			prev.next = x;
        			prev = x;
        		}
        	}
        	curr = x.next;
        	count = 1;
        	x = curr;
        }
        if(prev != null) {
    		prev.next = x;
    	}
        return newHead;
    }
}

public class RemoveDuplicateListII {
	public static void main(String args[]) {
		RemoveDuplicateListIISolution obj = new RemoveDuplicateListIISolution();
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(3);
		ListNode l8 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		ListNode res = obj.deleteDuplicates(l1);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}