from typing import List
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if (s == None):
            return 0
        
        i = 0
        j = len(s)-1

        while(i < j):
            temp = s[j]
            s[j] = s[i]
            s[i] = temp
            i+=1
            j-=1

s = 'u d h a y'.split(' ')
Solution().reverseString(s)
print(s)

