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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserNodesHead=new ListNode(-1), greaterEqNodes=new ListNode(-1);
        ListNode lesserNodes=lesserNodesHead, greaterEqNodesHead=greaterEqNodes;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                lesserNodes.next=temp;
                lesserNodes=lesserNodes.next;
            }else{
                greaterEqNodes.next=temp;
                greaterEqNodes=greaterEqNodes.next;
            }
            temp=temp.next;
        }
        greaterEqNodes.next=null;
        lesserNodes.next=greaterEqNodesHead.next;
    
        return lesserNodesHead.next;
    }
}