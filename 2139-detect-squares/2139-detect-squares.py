class DetectSquares:

    def __init__(self):
        self.pts_count_dict={}


    def add(self, point: List[int]) -> None:
        # for px,py in point:
        px=point[0]
        py=point[1]
        new_point=(px,py) #list to tuple as dict key cannot be list
        curr_count=self.pts_count_dict.get(new_point,0)
        self.pts_count_dict[new_point]=curr_count+1 #inc freq by one

    def count(self, point: List[int]) -> int:
        # self.add(point)
        q_x=point[0]
        q_y=point[1]
        # multiplier=self.pts_count_dict[(q_x,q_y)]
        multiplier=1
        matches=0
        for pt, freq in self.pts_count_dict.items():
            x=pt[0]
            y=pt[1]
            if x==q_x and y==q_y:
                continue
            if abs(x-q_x)!=abs(y-q_y): #for a square height and width have to be the same
                continue
            matches+= (freq * self.pts_count_dict.get((q_x,y),0) * self.pts_count_dict.get((x,q_y),0))
        return matches*multiplier


# Your DetectSquares object will be instantiated and called as such:
# obj = DetectSquares()
# obj.add(point)
# param_2 = obj.count(point)