# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

#Took 2 attempts!
class Solution(object):
    # Space Complexity: O(1)
    # Fast Pointer Slow Pointer method
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return None
        slow = head
        fast = head
        count = 0
        prev = head
        while fast is not None:
            if count < n:
                count += 1
            else:
                prev = slow
                slow = slow.next
            fast = fast.next
        if slow != head:
            prev.next = slow.next
            return head
        else:
            return head.next

    '''   
    # Space Complexity: O(n) 
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        nodes = []
        while head is not None:
            nodes.append(head)
            head = head.next
        last = len(nodes)
        remove = last - n
        if remove == 0:
            return nodes[0].next
        toRemove = nodes[remove]
        nodes[remove - 1].next = toRemove.next
        return nodes[0]
    '''

# Test Cases Data
'''
a = ListNode(1)
b = ListNode(2)
c = ListNode(3)
m = ListNode(4)
n = ListNode(5)
o = ListNode(6)
a.next = b
b.next = c
c.next = m
m.next = n
n.next = o
'''