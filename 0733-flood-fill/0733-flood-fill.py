class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.recursiveFloodCompute(image, sr, sc, image[sr][sc], color, set())
        return image
    def recursiveFloodCompute(self, image, r, c, initialC, targetC, visited_set):
        visited_set.add((r, c))
        image[r][c]=targetC
        directions=[[-1,0], [1,0], [0,-1], [0,1]]
        for direction in directions:
            dx, dy=direction
            new_r=r+dx
            new_c=c+dy
            if new_r<0 or new_c<0 or new_r>=len(image) or new_c>=len(image[0]):
                continue
            if image[new_r][new_c]==initialC and (new_r, new_c) not in visited_set:
                self.recursiveFloodCompute(image, new_r, new_c, initialC, targetC, visited_set)
