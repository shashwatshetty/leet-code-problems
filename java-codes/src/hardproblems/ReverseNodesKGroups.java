package hardproblems;

// Took 1 attempt
// Time Taken To Solve: 87 mins
class ReverseNodesKGroupsSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null) {
    		return head;
    	}
        ListNode traverse = head;
        int idx = 1;
        int end = k;
        ListNode prev = null;
        while(traverse != null) {
        	if(isReversible(traverse, k)) {
        		ListNode start = traverse;
        		ListNode n = traverse.next;
        		while(n != null && idx <= end - 1) {
        			ListNode temp = n.next;
        			n.next = traverse;
        			traverse = n;
        			n = temp;
        			idx++;
        			if(idx == k) {
        				head = traverse;
        			}
        		}
        		if(prev == null) {
        			prev = start;
        		}else {
        			prev.next = traverse;
        			prev = start;
        		}
        		start.next = null;
        		traverse = n;
        		end += k;
        		idx++;
        	}else{
        		if(prev != null) {
        			prev.next = traverse;
        		}
        		break;
        	}
        }
        return head;
    }

    public boolean isReversible(ListNode m, int k) {
    	int count = 1;
    	while(m != null) {
    		if(count == k) {
    			return true;
    		}
    		count++;
    		m = m.next;
    	}
    	return false;
    }
}

public class ReverseNodesKGroups {
	public static void main(String args[]) {
		ReverseNodesKGroupsSolution obj = new ReverseNodesKGroupsSolution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode ans = obj.reverseKGroup(l1, 2);
		while(ans != null) {
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}