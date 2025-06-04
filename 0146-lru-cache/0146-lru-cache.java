class LRUCache {
    class DoublyListNode{
        int key;
        int val;
        DoublyListNode prev;
        DoublyListNode next;
        
        DoublyListNode(int key, int val){
            this.key=key;
            this.val=val;
            this.prev=null;
            this.next=null;
        }
    }

    private int capacity;
    private DoublyListNode head, tail;
    // Insert at tail, remove from head
    HashMap<Integer, DoublyListNode> hMap;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new DoublyListNode(-1,-1);
        this.tail=new DoublyListNode(-1,-1);
        this.tail.prev=this.head;
        this.head.next=this.tail;
        this.hMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(this.hMap.containsKey(key)){
            this.moveToEnd(key);
            return this.hMap.get(key).val;
        }
        return -1;
    }
    
    private void moveToEnd(int key){
        DoublyListNode tmp=this.removeFromCache(key);
        this.addToCache(tmp.key, tmp.val);
    }
    private DoublyListNode removeFromCache(int key){
            DoublyListNode nodeToRemove=this.hMap.get(key);
            nodeToRemove.prev.next=nodeToRemove.next;
            nodeToRemove.next.prev=nodeToRemove.prev;
            this.hMap.remove(key);
            return nodeToRemove;
    }

    private void addToCache(int key, int value){
            DoublyListNode nodeToAdd=new DoublyListNode(key, value);
            nodeToAdd.next=this.tail;
            nodeToAdd.prev=this.tail.prev;
            nodeToAdd.prev.next=nodeToAdd;
            this.tail.prev=nodeToAdd;
            this.hMap.put(key, nodeToAdd);
    }
    public void put(int key, int value) {
        if(hMap.containsKey(key)){
            //remove
            this.removeFromCache(key);
        }
        //add
        this.addToCache(key,value);
        //if max. remove from head
            if(this.hMap.size()>capacity){
            this.removeFromCache(this.head.next.key);
            }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */