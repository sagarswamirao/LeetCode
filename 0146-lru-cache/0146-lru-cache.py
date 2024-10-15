from collections import OrderedDict

class LRUCache:

    def __init__(self, capacity: int):
        self.cache=OrderedDict()
        self.capacity=capacity
        self.curr_size=0

    def get(self, key: int) -> int:
        if key not in self.cache.keys():
            return -1
        self.cache.move_to_end(key, last=True)
        return self.cache[key]

    def put(self, key: int, value: int) -> None:
        if key in self.cache.keys():
            self.cache[key]=value
            self.cache.move_to_end(key, last=True)
        else:
            if self.curr_size==self.capacity:
                self.cache.popitem(last=False)
                self.curr_size-=1
            self.cache[key]=value
            self.cache.move_to_end(key, last=True)
            self.curr_size+=1


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)