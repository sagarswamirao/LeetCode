class ListNode:
    def __init__(self, url):
        self.url=url
        self.prev=None
        self.next=None

class BrowserHistory:

    def __init__(self, homepage: str):
        self.head=ListNode(homepage)
        self.curr_head=self.head
        self.curr_index=0

    def visit(self, url: str) -> None:
        # lets check if already present
        # curr=self.head
        # temp_counter_index=0
        # while curr:
        #     if curr.url==url:
        #         break
        #     curr=curr.next
        #     temp_counter_index+=1
            
        # if curr:
        #     # url found in browser history
        #     self.curr_head=curr
        #     self.curr_head.next=None
        #     self.curr_index=temp_counter_index
        # else:
            # url not found in browser history
        newNode=ListNode(url)
        self.curr_head.next=newNode
        newNode.prev=self.curr_head
        self.curr_head=self.curr_head.next
        self.curr_index+=1

    def back(self, steps: int) -> str:
        curr=self.curr_head
        curr_step=0
        while curr and curr.prev and curr_step<steps:
            curr=curr.prev
            curr_step+=1
        self.curr_head=curr
        return curr.url


    def forward(self, steps: int) -> str:
        curr=self.curr_head
        curr_step=0
        while curr and curr.next and curr_step<steps:
            curr=curr.next
            curr_step+=1
        self.curr_head=curr
        return curr.url


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)