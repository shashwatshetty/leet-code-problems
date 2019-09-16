package mediumproblems;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

// Re-Done in 1 attempt
// Time Taken: 50 mins
class AddTwoNumbersSolution {
    /*
    Basic idea is, that we can add two numbers in any order i.e. left to right
    or right to left, to get the result, only maintaining the carry is important.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);       // start with a temporary mediumproblems.ListNode
        ListNode head = start;                     // used to store the head of the list
        int carry = 0;                             // used to store any carry
        // first two conditions are to check if the list is empty or no
        // third condition checks if after all additions there is a carry or no
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;    // add into carry
                l1 = l1.next;       // move to next digit
            }
            if(l2 != null){
                carry += l2.val;    // add into carry
                l2 = l2.next;       // move to next digit
            }
            start.next = new ListNode(carry % 10);      // represents the last digit, units place in carry
            carry = carry / 10;                            // reduce carry to whatever is in the tens place
            start = start.next;
        }
        return head.next;       // move to the next since temp has leading 0
    }

    public ListNode addTwoNumbersREDO(ListNode l1, ListNode l2) {
        ListNode prev = null, head = null;
        int carry = 0, add = 0;
        while(l1 != null || l2 != null || carry != 0) {
            if(l1 != null && l2 != null) {
                add = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null) {
                add = l1.val + carry;
                l1 = l1.next;
            }else if(l2 != null){
                add = l2.val + carry;
                l2 = l2.next;
            }else {
                add = carry;
            }
            ListNode x = new ListNode(add % 10);
            carry = add / 10;
            if(head == null) {
                head = x;
                prev = head;
            }else {
                prev.next = x;
                prev = x;
            }
        }
        return head;
    }
}

public class AddTwoNumbers {
    public static void main(String args[]){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(7);
        ListNode m3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        m1.next = m2;
        m2.next = m3;
        AddTwoNumbersSolution obj = new AddTwoNumbersSolution();
        ListNode res = obj.addTwoNumbers(n1,m1);
        System.out.println("The Resulting Number is: ");
        while(res != null){
            System.out.print(res.val);
            res = res.next;
        }
    }
}