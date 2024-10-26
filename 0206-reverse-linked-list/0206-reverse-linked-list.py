# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        curr=head
        prev=None

        # RECURSIVE
        # return self.reverseListRec(curr, prev)

        # ITEREATIVE
        while curr:
            next=curr.next
            curr.next=prev
            prev=curr
            curr=next
        return prev

    def reverseListRec(self, curr: Optional[ListNode], prev: Optional[ListNode]) -> Optional[ListNode]:
        if not curr:
            return prev
        if curr:
            next=curr.next
            curr.next=prev
        return self.reverseListRec(next, curr)