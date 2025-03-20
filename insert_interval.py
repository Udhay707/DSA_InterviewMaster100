from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        returnList = []
        index = 0
        n = len(intervals)

        # 1. Add intervals before newInterval (no overlap)
        while index < n and intervals[index][1] < newInterval[0]:
            returnList.append(intervals[index])
            index += 1
        
        # 2. Merge overlapping intervals
        while index < n and intervals[index][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[index][0])
            newInterval[1] = max(newInterval[1], intervals[index][1])
            index += 1
        returnList.append(newInterval)

        # 3. Add remaining intervals after newInterval
        while index < n:
            returnList.append(intervals[index])
            index += 1
        return returnList

sol = Solution().insert([[1,3],[6,9]], [2,5])
print(sol)

