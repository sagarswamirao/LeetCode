class ListNode:
    def __init__(self, val):
        self.val=val
        self.prev=None
        self.next=None

class MyLinkedList:

    def __init__(self):
        self.head=ListNode(-1)
        self.size=0

    def get(self, index: int) -> int:
        if index>=self.size:
            return -1
        curr=self.head
        for _ in range(index):
            curr=curr.next
        return curr.next.val

    def addAtHead(self, val: int) -> None:
        self.addAtIndex(0, val)

    def addAtTail(self, val: int) -> None:
        self.addAtIndex(self.size, val)

    def addAtIndex(self, index: int, val: int) -> None:
        if index>self.size:
            return -1

        curr=self.head
        for _ in range(index):
            curr=curr.next
        tempNext=curr.next
        curr.next=ListNode(val)
        curr.next.prev=curr
        curr.next.next=tempNext
        if tempNext:
            tempNext.prev=curr.next
        
        self.size+=1

    def deleteAtIndex(self, index: int) -> None:
        if index>=self.size:
            return -1

        curr=self.head
        for _ in range(index+1):
            curr=curr.next
        tempNext=curr.next
        if tempNext:
            curr.next.prev=curr.prev
            curr.prev.next=curr.next
        else:
            curr.prev.next=None

        self.size-=1

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)