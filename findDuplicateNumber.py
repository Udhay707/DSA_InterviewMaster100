from typing import List
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
         
        for i in range(0, len(nums)):
            while nums[i] != i+1:
                num = nums[i]
                position = num-1
                if nums[position] == nums[i]:
                    return nums[i]
                nums[i], nums[position] = nums[position], nums[i]
        
        return -1


sol = Solution().findDuplicate([3,1,3,4,2])
print(sol)