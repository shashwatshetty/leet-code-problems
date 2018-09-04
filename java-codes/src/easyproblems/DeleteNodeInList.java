package easyproblems;

// Took 1 attempt
// Time Taken To Solve: 14 mins
class DeleteNodeInListSolution {
    public void deleteNode(ListNode node) {
    	if(node == null){
    		return;
    	}
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class DeleteNodeInList{
	public static void main(String args[]){
		DeleteNodeInListSolution obj = new DeleteNodeInListSolution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		obj.deleteNode(l3);
		ListNode x = l1;
		while(x != null){
			System.out.print(x.val+" ");
			x = x.next;
		}
	}
}