class MinStack:

    def __init__(self):
        self.stack = []
        self.min_tracker = [float("inf")]
        self.curr_size = 0

    def push(self, val: int) -> None:
        self.stack.append(val)
        self.min_tracker.append(min(self.stack[-1], self.min_tracker[-1]))

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            self.min_tracker.pop()

    def top(self) -> int:
        return self.stack[-1] if self.stack else 0

    def getMin(self) -> int:
        return self.min_tracker[-1] if self.stack else 0


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
