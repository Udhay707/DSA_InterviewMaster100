from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) -1

        while(start<=end):
            mid = int(start + (end-start)/2)
            if(target == nums[mid]):
                return mid
            if(target < nums[mid]):
                end = mid-1
            elif(target > nums[mid]):
                start = mid+1          
        return -1
    
print(Solution().search([-1,0,3,5,9,12], 9))    