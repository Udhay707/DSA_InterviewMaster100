class Solution:
    def mySqrt(self, x: int) -> int:
        if (x==0 or x==1):
            return x
        
        start=0
        end = x
        while(start<=end):
            mid = start + (end - start) // 2
            if(mid*mid == x):
                return mid
            if(mid*mid < x):
                start = mid+1
            if(mid*mid > x):
                end = mid -1
        return abs(end)

sol = Solution()
print(sol.mySqrt(8))