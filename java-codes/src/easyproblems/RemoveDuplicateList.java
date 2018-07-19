package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 18 mins
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
class RemoveDuplicateListSolution {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
        ListNode prev = head;
        ListNode node = head.next;
        while(node != null){
        	if(prev.val == node.val){
        		prev.next = node.next;
        	}else{
        		prev = node;
        	}
        	node = node.next;
        }
        return head;
    }
}

public class RemoveDuplicateList{
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		n1.next = n3;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		RemoveDuplicateListSolution obj = new RemoveDuplicateListSolution();
		ListNode n = obj.deleteDuplicates(n1);
		while(n != null){
			System.out.print(n.val+" ");
			n = n.next;
		}

	}
}