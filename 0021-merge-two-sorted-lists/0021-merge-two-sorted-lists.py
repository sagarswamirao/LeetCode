# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        list3=ListNode(-1)
        list3head=list3
        list1head=list1
        list2head=list2
        while list1head and list2head:
            nextNode=None
            if list1head.val<list2head.val:
                nextNode=list1head
                list1head=list1head.next
            else:
                nextNode=list2head
                list2head=list2head.next

            list3head.next=nextNode
            list3head=list3head.next

        while list1head:
            nextNode=list1head
            list1head=list1head.next

            list3head.next=nextNode
            list3head=list3head.next       
        
        while list2head:
            nextNode=list2head
            list2head=list2head.next
            
            list3head.next=nextNode
            list3head=list3head.next      

        return list3.next