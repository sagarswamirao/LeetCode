class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        result=[]

        m=len(nums1)
        n=len(nums2)

        i=0
        j=0
        while i<m and j<n:
            
            item1=nums1[i]
            item2=nums2[j]

            if item1[0]==item2[0]:
                result.append([item1[0], item1[1]+item2[1]])
                i+=1
                j+=1
            elif item1[0]<item2[0]:
                result.append(list(item1))
                i+=1
            else:
                result.append(list(item2))
                j+=1
        
        while i<m:
            result.append(list(nums1[i]))
            i+=1
        
        while j<n:
            result.append(list(nums2[j]))
            j+=1
        
        return result
                