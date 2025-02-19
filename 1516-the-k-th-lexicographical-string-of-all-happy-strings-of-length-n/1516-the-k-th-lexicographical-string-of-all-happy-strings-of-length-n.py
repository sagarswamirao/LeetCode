class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        total_happy_count = 3 * (2 ** (n - 1))
        if k > total_happy_count: 
            return ""

        happy = ['a', 'b', 'c']
        suffix = {'a': ['b', 'c'], 'b': ['a', 'c'], 'c': ['a', 'b']}
        ans = []
        
        # Determine first character
        partition_size = (2 ** (n - 1))  # The size of each letter's partition
        first_idx = (k - 1) // partition_size  # 0 -> 'a', 1 -> 'b', 2 -> 'c'
        ans.append(happy[first_idx])  # Pick the first character
        k -= first_idx * partition_size  # Adjust k within the selected partition
        
        # Generate the rest of the string
        for i in range(1, n):
            partition_size //= 2  # Reduce partition size
            next_choices = suffix[ans[-1]]  # Get allowed next letters
            next_idx = (k - 1) // partition_size  # Choose between the two
            ans.append(next_choices[next_idx])  # Append the valid next character
            k -= next_idx * partition_size  # Adjust k for the next iteration

        return ''.join(ans)

        


# class Solution:
#     def getHappyString(self, n: int, k: int) -> str:
#         chars=['a','b','c']
#         result_array=[]

#         patterns_generated=0
#         def recursive(idx,n,ans):
#             nonlocal patterns_generated
#             if len(ans)==n:
#                 patterns_generated+=1
#                 if patterns_generated==k:
#                     result_array.append("".join(ans)) 
#                 return
                
#             if len(ans)>n:
#                 return 

#             for i in range(len(chars)):
#                 if i!=idx:
#                     ans.append(chars[i])
#                     recursive(i,n,ans)
#                     ans.pop()
        
#         recursive(-1,n,[])
#         return result_array[0] if len(result_array)==1 else ""