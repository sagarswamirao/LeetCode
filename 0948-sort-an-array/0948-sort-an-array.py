class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        n=len(nums)

        # return self.selectionSort(nums, n)
        # return self.bubbleSort(nums, n)
        # return self.insertionSort(nums, n)
        self.mergeSort(nums,0, n-1)
        # self.quickSort(nums,0, n-1)
        return nums

    def insertionSort(self, nums, n):
        for i in range(0,n-1):
            j=i+1
            while j>0 and nums[j-1]>nums[j]:
                self.swap(nums,j-1,j)
                j-=1
        return nums

    def bubbleSort(self, nums, n):
        for i in range(0,n):
            for j in range(1,n-i):
                if nums[j-1]>nums[j]:
                    self.swap(nums,j-1,j)
        return nums

    def selectionSort(self, nums, n):
        for i in range(0,n):
            swap_index=i
            for j in range(i+1,n):
                if nums[j]<nums[swap_index]:
                    swap_index=j
            self.swap(nums,i,swap_index)
        return nums

    def mergeSort(self, nums, low, high):
        if low>=high:
            return
        mid=(low+high)//2
        self.mergeSort(nums,low,mid)
        self.mergeSort(nums,mid+1,high)
        self.merge(nums,low,mid,high)


    def merge(self,nums, low, mid, high):
        start=low
        end=mid+1
        tmp_arr=[]
        while start<=mid and end<=high:
            if nums[start]<nums[end]:
                tmp_arr.append(nums[start])
                start+=1
            else:
                tmp_arr.append(nums[end])
                end+=1       

        while start<=mid:
            tmp_arr.append(nums[start])
            start+=1

        while end<=high:
            tmp_arr.append(nums[end])
            end+=1           

        for i in range(low,high+1):
            nums[i]=tmp_arr[i-low]

    def quickSort(self,nums,low,high):
        if low>=high:
            return
        partition_index=self.quickPartition(nums, low, high)
        self.quickSort(nums,low,partition_index-1)
        self.quickSort(nums,partition_index+1,high)

    def quickPartition(self, nums, low, high):
        i=low
        j=high
        pivotIndex=low
        while i<j:
            while i<high and nums[i]<=nums[pivotIndex]:
                i+=1
            while j>low and nums[j]>nums[pivotIndex]:
                j-=1
            if i<j:
                self.swap(nums,i,j)
        self.swap(nums,pivotIndex,j)
        return j
    
    def swap(self, arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]