from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:

        start = 0 
        end = len(nums)-1

        while(start <=end ):
            mid = start + (end-start) // 2
            if(mid+1 < len(nums) and nums[mid] > nums[mid+1]):
                return nums[mid+1]
            if(mid-1 >= 0 and nums[mid] < nums[mid-1]):
                return nums[mid]
            
            if(nums[start] < nums[mid]):
                start = mid+1
            else:
                end = mid-1

        return nums[0]
    
sol = Solution().findMin([1,2])
print(sol)