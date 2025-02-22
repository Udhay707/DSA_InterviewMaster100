class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = -1*n
        return self.rec(x, n, {})

    def rec(self, x: float, n: int, found: dict) -> float:
        if(n ==0):
            return 1
        if(n == 1):
            return x
        if(n in found):
            return found[n]
        product = self.rec(x, n//2 , found) * self.rec(x, n - n//2, found)
        found[n] = product
        return product
    
sol = Solution()
ans = sol.myPow(2, 10)
print(ans)