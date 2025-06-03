class Solution:
    def checkValidString(self, s: str) -> bool:
        #using 2 variables
        min=0
        max=0

        for char in s:
            if char=='(':
                min+=1
                max+=1
            elif char==')':
                min-=1
                max-=1
            else: #'*'
                min-=1
                max+=1
            
            #min can never go below 0
            if min<0:
                min=0
            
            # edgecase of starting char itself is ) or more )
            if max<0:
                return False
        
        return min==0