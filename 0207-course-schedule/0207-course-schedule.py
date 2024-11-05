class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preq_map={}
        for course, preq in prerequisites:
            if course not in preq_map:
                preq_map[course]=[]
            preq_map[course].append(preq)
        
        for course in preq_map.keys():
            if self.dfs_has_cycle(preq_map, course, set()):
                return False
        return True
    
    def dfs_has_cycle(self, preq_map, course, visited):
        if course in visited:
            return True
        if course not in preq_map or len(preq_map[course])==0:
            return False
        visited.add(course)
        for neighbor in preq_map[course]:
            if self.dfs_has_cycle(preq_map, neighbor,visited):
                return True
            preq_map[course].remove(neighbor)
        visited.remove(course)
        return False