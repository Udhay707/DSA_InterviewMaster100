from typing import List
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length ==1:
            return
        
        i = length-2
        while(i>=0):
            if nums[i] < nums[i+1]:
                break
            i-=1

        if i<0:
            nums.reverse()
            return
        
        j = length-1
        while j > i:
            if nums[j] > nums[i]:
                break
            j-=1
        
        nums[i], nums[j] = nums[j], nums[i]

        nums[i+1:] = nums[i+1:][::-1]
k = [2,3,1]
sol = Solution().nextPermutation(k)
print(k)