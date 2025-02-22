from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indx_dict = { x:i for i,x in enumerate(nums)}

        for index,num in enumerate(nums):
            if((target - num) in indx_dict and indx_dict[target-num] != index):
                return [index, indx_dict[target-num]]
        return [-1, -1]

if __name__ == '__main__':
    list = [1,2,3,4,5]
    print( Solution().twoSum(list, 3))