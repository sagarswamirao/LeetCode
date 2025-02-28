/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node getNode(Node curr, HashMap<Node, Node> hMap){
        if(curr==null){
            return null;
        }
        if(!hMap.containsKey(curr)){
            hMap.put(curr,new Node(curr.val));
        }
        return hMap.get(curr);
    }
    
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hMap=new HashMap<>();
        Node curr=head;
        Node deepHead=new Node(-1);
        Node deepCurr=deepHead;
        while(curr!=null){
            int currVal=curr.val;
            deepCurr.next=this.getNode(curr,hMap);
            deepCurr=deepCurr.next;
            deepCurr.random=this.getNode(curr.random,hMap);
            curr=curr.next;
        }
        return deepHead.next;
    }
}