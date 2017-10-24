#Took 3 attempts!!
class Solution(object):
    #Python Specific Method:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        import math
        combinedList = nums1 + nums2
        totalLength = len(combinedList)
        combinedList.sort()
        #print "Combined List: ",combinedList
        if totalLength % 2 == 0:
            indx1 = math.floor((totalLength-1)/2.0)
            indx2 = math.ceil((totalLength-1)/2.0)
            return (combinedList[int(indx1)] + combinedList[int(indx2)])/2.0
        else:
            indx = math.ceil((totalLength-1)/2.0)
            #print "Index: ", indx
            return combinedList[int(indx)]
            
    '''
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        totalLength = len(nums1) + len(nums2)
        i = 0
        j = 0
        k = 0
        median = (totalLength/2) + 1
        while k <= median:
            if i < len(nums1) and j < len(nums2):
                if nums1[i] <= nums2[j]:
                    i += 1
                else:
                    j += 1
                k += 1
            elif i >= len(nums1) and j < len(nums2):
                j += 1
                k += 1
            else:
                i += 1
                k += 1
        if i < j:
            return k
        else:
            return k
    '''