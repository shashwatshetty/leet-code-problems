package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 36 mins
class ReverseLinkedListIISolution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
        	return head;
        }
        int count = 1;
        ListNode h = head;
        ListNode prev = null;
        while(h != null && count <= n) {
        	if(count >= m) {
        		ListNode nxt = h.next;
        		ListNode last = h;
        		while(nxt != null && count < n) {
        			ListNode t = nxt.next;
        			nxt.next = h;
        			h = nxt;
        			nxt = t;
        			count++;
        		}
        		last.next = nxt;
        		if(m != 1){
        			prev.next = h;
        		}else{
        			head = h;
        		}
        	}
        	count++;
        	prev = h;
        	h = h.next;
        }
        return head;
    }
}

public class ReverseLinkedListII {
	public static void main(String aargs[]) {
		ReverseLinkedListIISolution obj = new ReverseLinkedListIISolution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode ans = obj.reverseBetween(l1, 1, 2);
		while(ans != null) {
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}