class Solution(object):
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
            
            