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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode tail=head;
        int carry=0;
        while(l1!=null || l2!=null){
            int l1value=0;
            int l2value=0;
            if(l1!=null){
                l1value=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                l2value=l2.val;
                l2=l2.next;
            }
            int sum=carry + (l1value + l2value);
            tail.next=new ListNode(sum%10);
            tail=tail.next;
            carry= (sum>9)?1:0;
        }
        if(carry==1){
            tail.next=new ListNode(1);
        }
        return head.next;
    }
}