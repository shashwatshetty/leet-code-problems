# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

#Took 4 attempts!!
class Solution(object):
    #Crude Method
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        num1 = ''
        num2 = ''
        node = None
        #Append 1st number into a string
        while l1 != None:
            num1 += str(l1.val)
            l1 = l1.next
        #Append 2nd number into a string    
        while l2 != None:
            num2 += str(l2.val)
            l2 = l2.next
        #Add the numbers and store as string in reverse order   
        res = str(int(num1[::-1])+int(num2[::-1]))
        #convert string to linked list
        nextNode = ListNode(int(res[0]))
        for i in range(1,len(res)):
            node = ListNode(int(res[i]))
            node.next = nextNode
            nextNode = node
        if node != None:
            return node
        else:
            return nextNode