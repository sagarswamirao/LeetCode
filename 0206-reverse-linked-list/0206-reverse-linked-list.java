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

    public ListNode reverseList(ListNode head) {
        // return reverseListIterative(head);
        return reverseListRecursive(head,null);
    }

    public ListNode reverseListRecursive(ListNode head,ListNode previous) {
        if(head!=null){
            ListNode nextNode=head.next;
            head.next=previous;
            return reverseListRecursive(nextNode, head);
        }
        return previous;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode previous=null;
        while(head!=null){
            ListNode nextNode=head.next;
            head.next=previous;
            previous=head;
            head=nextNode;
        }
        return previous;
    }
}