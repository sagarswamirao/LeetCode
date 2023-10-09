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
    public ListNode middleNode(ListNode head) {
        List<ListNode> li=new ArrayList<ListNode>();
        while(head.next!=null){
            li.add(head);
            head=head.next;
        }
        li.add(head);
        int size=li.size();
        if(size%2==0){
            System.out.println(size/2);
            return li.get((size/2));
        }else{
            return li.get((size)/2);
        }
    }
}