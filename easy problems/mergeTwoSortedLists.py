# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    # Method not able to handle certain test cases.
    '''
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None and l2 is None:
            return None
        head = None
        count = 0
        prev = None
        while l1 is not None or l2 is not None:
            val1 = float('inf')
            val2 = float('inf')
            if l1 is not None:
                val1 = l1.val
            if l2 is not None:
                val2 = l2.val
            if val1 <= val2:
                new = ListNode(val1)
                l1 = l1.next
            else:
                new = ListNode(val2)
                l2 = l2.next
            if prev is not None:
                prev.next = new
            if count == 1:
                head = prev
            prev = new
            count += 1
        return head
    '''

    # Cruder Method requiring 2 passes.
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None and l2 is None:
            return None
        sortVals = []
        while l1 is not None or l2 is not None:
            val1 = float('inf')
            val2 = float('inf')
            if l1 is not None:
                val1 = l1.val
            if l2 is not None:
                val2 = l2.val
            if val1 <= val2:
                sortVals = [val1] + sortVals
                l1 = l1.next
            else:
                sortVals = [val2] + sortVals
                l2 = l2.next
        next = ListNode(sortVals[0])
        for val in sortVals[1:]:
            new = ListNode(val)
            new.next = next
            next = new
        return next

# Test Cases Data
'''
a = ListNode(1)
b = ListNode(2)
c = ListNode(4)
m = ListNode(1)
n = ListNode(3)
o = ListNode(4)
a.next = b
b.next = c
m.next = n
n.next = o
'''