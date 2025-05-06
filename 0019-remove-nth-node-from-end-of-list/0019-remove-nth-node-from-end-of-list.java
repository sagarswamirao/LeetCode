/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode fast=dummy.next;
        ListNode slow=dummy.next;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        //to remove 0th element
        if (fast == null) return head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}











