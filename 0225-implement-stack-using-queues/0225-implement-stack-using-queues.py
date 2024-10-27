from collections import deque
class MyStack:

    def __init__(self):
        self.d1=deque() #insert
        self.d2=deque() #poll
        self.top_val=-1

    def push(self, x: int) -> None:
        while self.d2:
            popEle=d2.popleft()
            self.d1.append(popEle)
        self.d1.append(x)
        self.top_val=x
#  q1 1 2 3 4 5
#  get top: 5
#  pop
#  q1
#  q2 1 2 3 4

    def pop(self) -> int:
        if self.empty():
            return -1
        popEle=None
        while self.d1:
            if len(self.d1)==1:
                popEle=self.d1.popleft()
                break
            self.d2.append(self.d1.popleft())
        self.top_val=-1 if not self.d2 else self.d2[-1]
        self.d1, self.d2= self.d2, self.d1
        return popEle
            
    def top(self) -> int:
        return self.top_val

    def empty(self) -> bool:
        if not self.d1 and not self.d2:
            self.top_val=-1
            return True   
        return False


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()