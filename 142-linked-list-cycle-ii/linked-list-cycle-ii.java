/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        //came out of null, no cycle found
        if(fast==null || fast.next==null){
            return null;
        }
        ListNode slow2=head;
        while(slow!=slow2){
            slow=slow.next;
            slow2=slow2.next;
        }
        return slow;
    }
}