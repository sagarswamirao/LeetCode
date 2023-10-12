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
    public double generateNumber(ArrayList<Integer> nums){
        double sum=0;
            for(int i=0;i<nums.size();i++){
            sum*=10;
            sum+=nums.get(i);
        }
        return sum;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode=new ListNode(0);
        ListNode curr=headNode;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            curr=curr.next;
        }
        return headNode.next;
    }
}