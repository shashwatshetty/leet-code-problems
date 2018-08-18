package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 45 mins
class RotateListSolution {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null || head.next == null){
    		return head;
    	}
        ListNode tail = null;
        ListNode x = head;
        int count = 0;
        while(x != null){
        	tail = x;
        	count++;
        	x = x.next;
        }
        ListNode temp = null;
        int iter = count - (k % count);
        for(int i = 1; i <= iter; i++){
        	temp = head.next;
        	head.next = tail.next;
        	tail.next = head;
        	tail = head;
        	head = temp;
        }
        return head;
    }
}

public class RotateList{
	public static void main(String args[]){
		RotateListSolution obj = new RotateListSolution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode a1 = new ListNode(0);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		ListNode ans = obj.rotateRight(n3, 3);
		while(ans != null){
			System.out.print(ans.val+" ");
			ans = ans.next;
		}
	}
}