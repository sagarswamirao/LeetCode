class Node{
    private Node[] a;
    private boolean flag;

    public Node(){
        flag=false;
        a=new Node[26];
    }

    public void setChildNode(Character c, Node node){
        a[c-'a']=node;
    }

    public boolean containsLetter(Character c){
        return a[c-'a']==null? false: true;
    }

    public boolean isEnd(){
        return flag;
    }

    public void setEnd(){
        flag=true;
    }

    public Node getNode(Character c){
        return a[c-'a'];
    }
}
class Trie {
    Node root;
    Trie() {
        root=new Node();
    }

    void insert(String word) {
        Node head=this.root;
        for(int i=0;i<word.length();i++){
            if(!head.containsLetter(word.charAt(i))){
                head.setChildNode(word.charAt(i),new Node());
            }
            head=head.getNode(word.charAt(i));
        }
        head.setEnd();
    }

    boolean search(String word) {
        Node head=root;
        for(int i=0;i<word.length();i++){
            if(!head.containsLetter(word.charAt(i))){
                return false;
            }
            head=head.getNode(word.charAt(i));
        }
        return head.isEnd();   
    }

    boolean startsWith(String prefix) {
        Node head=root;
        for(int i=0;i<prefix.length();i++){
            if(!head.containsLetter(prefix.charAt(i))){
                return false;
            }
            head=head.getNode(prefix.charAt(i));
        }
        return true;           
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */