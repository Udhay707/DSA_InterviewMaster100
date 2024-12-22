from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        lenght = len(nums)
        if lenght == 1:
            return nums[0]
        sum = [0]* lenght
        sum[0] = nums[0]
        sum[1] = max(nums[0], nums[1])
         
        for i in range(2, lenght):
            sum[i] = max(nums[i] + sum[i-2] , sum[i-1])
            
        return sum.pop()
    
    def robO1(self, nums):
        lenght = len(nums)
        if lenght==1:
            return nums[0]
        
        prevSum = nums[0]
        sum= max(nums[0], nums[1])

        for i in range(2, lenght):
            temp = sum
            sum = max(nums[i] + prevSum, sum)
            prevSum = temp

            
        return sum


nums = [2,1,1,2]
solution = Solution()
print(solution.rob(nums))
print(solution.robO1(nums))