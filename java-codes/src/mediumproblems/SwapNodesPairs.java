package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 35 mins
class SwapNodesPairsSolution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null && curr.next != null){
        	if(curr == head){
        		head = curr.next;
        	}
        	ListNode t = curr.next;
    		curr.next = t.next;
    		t.next = curr;
    		if(prev != null){
    			prev.next = t;
    		}
    		prev = curr;
        	curr = curr.next;
        }
        return head;
    }
}

public class SwapNodesPairs{
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		SwapNodesPairsSolution obj = new SwapNodesPairsSolution();
		ListNode ans = obj.swapPairs(n1);
		while(ans != null){
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}