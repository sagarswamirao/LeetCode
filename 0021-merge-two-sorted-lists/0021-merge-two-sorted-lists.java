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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode l1_head=list1;
      ListNode l2_head=list2;
      ListNode l3_tail=new ListNode(0);
      ListNode l3_head=l3_tail;
      while(l1_head!=null || l2_head!=null){
          if(l1_head!=null && l2_head!=null){
          if(l1_head.val>l2_head.val){
              l3_tail.next=new ListNode(l2_head.val);
              l3_tail=l3_tail.next;
              l2_head=l2_head.next;
          }else if(l1_head.val < l2_head.val){
              l3_tail.next=new ListNode(l1_head.val);
              l3_tail=l3_tail.next;
              l1_head=l1_head.next;
          }else{
              l3_tail.next=new ListNode(l1_head.val);
              l3_tail=l3_tail.next;
              l3_tail.next=new ListNode(l2_head.val);
              l3_tail=l3_tail.next;
              l1_head=l1_head.next;
              l2_head=l2_head.next;
          }
        }else if(l1_head!=null){
            l3_tail.next=new ListNode(l1_head.val);
            l3_tail=l3_tail.next;
            l1_head=l1_head.next;
        }else if(l2_head!=null){
            l3_tail.next=new ListNode(l2_head.val);
            l3_tail=l3_tail.next;
            l2_head=l2_head.next;
        }

      }  
      return l3_head.next;
    }
}