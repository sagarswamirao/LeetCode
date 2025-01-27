class TrieNode{
    TrieNode[] children;
    boolean flag;
    TrieNode(){
        this.children=new TrieNode[26];
        this.flag=false;
    }

    public boolean isEnd(){
        return this.flag;
    }

    public void setEnd(){
        this.flag=true;
    }

    public TrieNode getNode(char ch){
        return this.children[ch - 'a'];
    }
}

public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode head=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(head.getNode(c)==null){
                head.children[c-'a']= new TrieNode();
            }
            head=head.children[c-'a'];
        }
        head.flag=true;
    }
    
    public boolean search(String word) {
        TrieNode head=this.root;
        return this.dfs(word, 0, head);
    }

    public boolean dfs(String word, int index, TrieNode head){
        
        for(int i=index;i<word.length();i++){
            
            if(word.charAt(i)=='.'){
                for(int t=0;t<26;t++){
                    if(head.children[t]!=null){
                        if(this.dfs(word, i+1, head.children[t])){
                            return true;
                        }
                    }   
                }
                return false;
            }else{
                if(head.getNode(word.charAt(i))==null){
                    return false;
                }
                head=head.getNode(word.charAt(i));
            }
        }
        return head.flag;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */