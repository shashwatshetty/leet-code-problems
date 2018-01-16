
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode head = start;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            start.next = new ListNode(carry % 10);
            carry = carry / 10;
            start = start.next;
        }
        return head.next;
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