package mediumproblems;

// Referred The Solution
// Time Taken To Solve: 101 mins
class SortedListToBstSolution {
	/*
		Below approach is incorrect.
	*/
	/*
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
        	return null;
        }
        int len = 0;
        ListNode x = head;
        while(x != null){
        	x = x.next;
        	len++;
        }
        return buildTree(head, 0, len - 1);
    }

    public TreeNode buildTree(ListNode h, int s, int e){
    	if(s == e){
    		return new TreeNode(h.val);
    	}else if(s > e){
    		return null;
    	}else{
    		ListNode m = getMid(h, s, e);
    		TreeNode r = new TreeNode(m.val);
    		r.left = buildTree(h, s, ((s + e)/2) - 1);
    		r.right = buildTree(m.next, ((s + e)/2), e);
    		return r;
    	}
    }

    public ListNode getMid(ListNode n, int s, int e){
    	ListNode x = n;
    	int c = 0, m = (s + e)/2;
    	while(c != m){
    		x = x.next;
    		c++;
    	}
    	System.out.println(x.val);
    	return x;
    }
    */

	/*
		Below approach uses a fast pointer slow pointer logic
		along with recursion to solve the problem. Initially
		both fast and slow pointers are the head of the list, and
		while loop runs till either fast or its next is not null. When
		fast reaches the end, slow will be the mid. The prev pointer
		is used to disconnect the list while the next node of the slow will
		be the head of the right part.
	*/
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	if(head.next == null){
    		return new TreeNode(head.val);
    	}
    	ListNode s = head, f = head, prev = head;
    	while( f != null && f.next != null){
    		prev = s;
    		s = s.next;
    		f = f.next.next;
    	}
    	prev.next = null;
    	TreeNode r = new TreeNode(s.val);
    	r.left = sortedListToBST(head);
    	r.right = sortedListToBST(s.next);
    	return r;
    }
}

public class SortedListToBst{
	public static void main(String args[]){
		SortedListToBstSolution obj = new SortedListToBstSolution();
		ListNode l1 = new ListNode(-10);
		ListNode l2 = new ListNode(-3);
		ListNode l3 = new ListNode(0);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		TreeNode ans = obj.sortedListToBST(l1);
		printTree(ans);
	}

	public static void printTree(TreeNode n){
		if(n == null){
			return;
		}else{
            System.out.print(n.val);
			printTree(n.left);
			printTree(n.right);
		}
	}
}