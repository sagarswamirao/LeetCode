class Solution:
    def isValid(self, s: str) -> bool:
        mapper={
            '(':')',
            '{':'}',
            '[':']'
        }
        stack=[]
        for char in s:
            if char in mapper:
                stack.append(mapper[char])
            else:
                if len(stack)==0:
                    return False
                elif stack[-1]==char:
                    stack.pop()
                else:
                    return False
        
        return True if len(stack)==0 else False