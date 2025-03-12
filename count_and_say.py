class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        toCount = self.countAndSay(n-1)
        prev = toCount[0]
        frequency = 1
        ans = ""
        for i in range (1, len(toCount)):
            if prev == toCount[i]:
                frequency += 1
            else:
                ans += str(frequency) + str(prev)
                prev = toCount[i]
                frequency = 1
        return ans + str(frequency) + str(prev)

sol = Solution().countAndSay(4)
print(sol)