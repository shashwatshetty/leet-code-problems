package hardproblems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// Took 1 attempt
// Time Taken To Solve: 37 mins
class ListNode {
 	int val;
 	ListNode next;
 	ListNode(int x) { val = x; }
}

class MergeKSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0){
    		return null;
    	}
        ListNode prev = null, head = null;
        List<ListNode> kList = new ArrayList<ListNode>(Arrays.asList(lists));
        while(!kList.isEmpty()){
        	ListNode minNode = null;
        	int minVal = Integer.MAX_VALUE;
        	for(ListNode n : kList){
        		if(n != null && n.val < minVal){
        			minVal = n.val;
        			minNode = n;
        		}
        	}
        	kList.remove(minNode);
        	if(minNode != null){
	        	ListNode curr = new ListNode(minVal);
	        	if(head == null){
	        		head = curr;
	        	}
	        	if(prev != null){
	        		prev.next = curr;
	        	}
	        	if(minNode.next != null){
	        		minNode = minNode.next;
	        		kList.add(minNode);
	        	}
	        	prev = curr;
        	}
        }
        return head;
    }
}

public class MergeKSortedLists{
	public static void main(String args[]){
		MergeKSortedListsSolution obj = new MergeKSortedListsSolution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;

		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(6);
		ListNode a4 = new ListNode(8);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;

		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(2);
		ListNode b3 = new ListNode(4);
		ListNode b4 = new ListNode(8);
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;

		ListNode[] nl = {null, null, null};
		ListNode[] l = {l1, a1, b1};
		ListNode ans = obj.mergeKLists(l);
		while(ans != null){
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}