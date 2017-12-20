class Solution(object):
	#time spent 2 hours
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height)
        i = 0
        trapped = 0
        startHeight = 0
        stack = []
        while i < length:
        	if height[i] < startHeight:
        		stack.push(startHeight - height[i])
        	elif height[i] >= startHeight:
        		trapped += sum(stack)
        		stack = []
        		startHeight = height[i]
        	i += 1