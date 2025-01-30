from typing import List
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        sortedList: List[int] = []
        values: List[int] = [1]*len(nums)
        max_num = 1
        for i in range(1, len(nums)):
            for j in range(0, i):
                if(nums[j] < nums[i] and values[i] <= values[j]):
                    values[i] = values[j]+1
            max_num = max(max_num, values[i])
        return max_num

            

sol = Solution()
print(sol.lengthOfLIS([10,9,2,5,3,7,101,18]))