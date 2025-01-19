from typing import List, Set, Dict
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseDict = {}
        for i in prerequisites:
            if i[0] in courseDict:
                courseDict[i[0]].append(i[1])
            else:
                courseDict[i[0]] = [i[1]]
        visited = set()
        dp = set()
        for i in range(0, numCourses):
            visited.add(i)
            if not self.search(courseDict, i, visited, dp):
                return False
        return True

    def search(self, course_dict: Dict, start: int, visited : Set, dp : Set) -> bool:
        if start in dp:
            return True
        if start not in course_dict:
            dp.add(start)
            return True
        for i in course_dict[start]:
            if i in visited and i not in dp:
                return False
            visited.add(i)
            if not self.search(course_dict, i, visited, dp):
                return False
            visited.remove(i)
        dp.add(start)
        return True
    
numCourses = 4
preRequisites = [[0,1],[3,1],[1,3],[3,2]]
sol = Solution().canFinish(numCourses, preRequisites)
print(sol)