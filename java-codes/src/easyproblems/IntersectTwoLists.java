package easyproblems;

// Referred The Solution
// Time Taken To Solve: 100 mins
class IntersectTwoListsSolution {
	/*
		Below approach uses two pointers to traverse the list one at a time. When either of the list
		reach the end, it start from the head of the other list. This way both pointers will travel the
		length of both lists if no intersection is present or will meet at the intersection node.
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null) {
    		return null;
    	}
        ListNode a = headA;
        ListNode b = headB;
        while(a != null || b != null) {
        	if(a == null) {
        		a = headB;
        	}
        	if(b == null) {
        		b = headA;
        	}
        	if(a == b) {
        		return a;
        	}else {
        		a = a.next;
        		b = b.next;
        	}
        }
        return null;
    }
}

public class IntersectTwoLists {
	public static void main(String args[]) {
		IntersectTwoListsSolution obj = new IntersectTwoListsSolution();
		ListNode al1 = new ListNode(1);
		ListNode al2 = new ListNode(2);
		ListNode al3 = new ListNode(3);
		ListNode al4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode bl1 = new ListNode(7);
		ListNode bl2 = new ListNode(6);
		ListNode l7 = new ListNode(8);
		ListNode l6 = new ListNode(9);
		al1.next = al2;
		al2.next = al3;
		al3.next = al4;
		al4.next = l6;
		bl1.next = bl2;
		bl2.next = l5;
		l5.next = l6;
		l6.next = l7;
		ListNode ans = obj.getIntersectionNode(al1, bl1);
		if(ans != null) {
			System.out.println(ans.val);
		}else {
			System.out.println(ans);
		}
	}
}