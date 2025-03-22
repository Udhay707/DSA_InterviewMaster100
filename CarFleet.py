from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pos_speed = [(p, t) for p, t in zip(position, speed)]
        stack = []
        for pos, sp in sorted(pos_speed, reverse=True):
            time_to_complete = (target - pos)/sp

            if len(stack) > 0 and time_to_complete <= stack[-1]:
                continue
            else:
                stack.append(time_to_complete)
        return len(stack)


sol = Solution().carFleet(target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3])
print(sol)
