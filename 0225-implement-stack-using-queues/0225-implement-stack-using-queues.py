from collections import deque
class MyStack:
#  q1 1 2 3 4 5
#  get top: 5
#  pop
#  q1
#  q2 1 2 3 4

    def __init__(self):
        self.d1=deque() #insert
        self.d2=deque() #poll

    def push(self, x: int) -> None:
        self.d1.append(x) # as we are always swapping and making sure to keep d2 empty

    def pop(self) -> int:
        if self.empty():
            return -1
        popEle=None
        while len(self.d1)>1:
            self.d2.append(self.d1.popleft())
        popEle=self.d1.popleft()
        self.d1, self.d2= self.d2, self.d1
        return popEle
            
    def top(self) -> int:
        if self.empty():
            return -1
        topEle=None
        while len(self.d1)>1:
            self.d2.append(self.d1.popleft())
        topEle=self.d1.popleft()
        self.d2.append(topEle)
        self.d1, self.d2= self.d2, self.d1
        return topEle


    def empty(self) -> bool:
        if len(self.d1)==0: # as we are always swapping and making sure to keep d2 empty
            return True   
        return False


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()