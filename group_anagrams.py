from typing import List
from functools import reduce
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sortValueMap = {}
        for string in strs:
            k = reduce(lambda x, y : x+y, sorted(list(string)),"")
            if k in sortValueMap:
                sortValueMap[k].append(string)
            else:
                sortValueMap[k] = [string]
        return list(sortValueMap.values())       

answer = Solution().groupAnagrams([""])
print(answer)         