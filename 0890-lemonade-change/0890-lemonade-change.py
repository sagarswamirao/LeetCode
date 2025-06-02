class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five_c=0
        ten_c=0
        for bill in bills:
            if bill==5:
                five_c+=1
            elif bill==10:
                ten_c+=1
                if five_c!=0:
                    five_c-=1
                else:
                    return False
            elif bill==20:
                if ten_c!=0 and five_c!=0:
                    ten_c-=1
                    five_c-=1
                elif five_c>=3:
                    five_c-=3
                else:
                    return False
        return True