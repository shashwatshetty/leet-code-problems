#TOok 2 attempts!!
class Solution(object):
    # Time Complexity : O(n)
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxArea = - float('inf')
        i = 0
        j = len(height) - 1
        while i < j:
            left = height[i]
            right = height[j]
            base = j - i
            depth = min(left, right)
            maxArea = max(base * depth, maxArea)
            if left < right:
                i += 1
            else:
                j -= 1
        return maxArea

    # Brute Force Method : TLE
    # TIme Complexity : O(n**2)
    '''
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        ordinates = []      
        i = 1
        while i <= len(height):
            coord = (i, height[i-1])
            ordinates.append(coord)
            i += 1
        mArea = - float('inf')
        for x1, y1 in ordinates:
            for x2, y2 in ordinates:
                h = min(y1, y2)
                b = abs(x1 - x2)
                mArea = max(b*h,mArea)
        return mArea
    '''