class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        '''
        a is repeated 2 times
        b is missing
        '''
        hset=set()
        one_n_xor=0
        grid_xor=0
        ans=[0,0]
        count=1
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                num=grid[i][j]
                if num in hset:
                    ans[0]=num
                else:
                    hset.add(num)
                    grid_xor^=num

                one_n_xor^=count
                count+=1
        
        ans[1]=grid_xor ^ one_n_xor

        return ans