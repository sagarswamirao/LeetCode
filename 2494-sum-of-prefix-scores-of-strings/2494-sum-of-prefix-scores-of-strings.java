class Solution {
    public int[] sumPrefixScores(String[] words) {
        int[] ans=new int[words.length];
        Trie trie=new Trie();
        for(String word:words){
            trie.insertWord(word);
        }
        for(int i=0;i<words.length;i++){
            ans[i]=trie.countPrefixsAndGetSum(words[i]);
        }
        return ans;
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root=new TrieNode();
    }
    public void insertWord(String word){
        TrieNode head=root;
        for(int i=0;i<word.length();i++){
            if(!head.containsLetter(word.charAt(i))){
                head.insertNode(word.charAt(i), new TrieNode());
            }
            head=head.getNode(word.charAt(i));
            head.incrementLetterCount();
        }
        head.incrementFlagCount();
    }

    public int countPrefixsAndGetSum(String word){
        TrieNode head=root;
        int prefixLetterTotal=0;
        //count prefix endings till word is reached, and at word count the letter count and subtract self
        for(int i=0;i<word.length();i++){
            if(!head.containsLetter(word.charAt(i))){
                return 0;
            }
            head=head.getNode(word.charAt(i));
            prefixLetterTotal+=head.getLetterCount();
        }
        return prefixLetterTotal;
    }
}
class TrieNode{
    TrieNode[] nodes;
    int letterCount;
    int flagCount;
    TrieNode(){
        nodes=new TrieNode[26];
        letterCount=0;
        flagCount=0;
    }
    public void incrementLetterCount(){
        letterCount++;
    }
    public int getLetterCount(){
        return letterCount;
    }
    public void incrementFlagCount(){
        flagCount++;
    }
    public int getFlagCount(){
        return flagCount;
    }
    public boolean containsLetter(Character c){
        if(nodes[c-'a']==null){
            return false;
        }
        return true;
    }
    public void insertNode(Character c, TrieNode node){
        nodes[c-'a']=node;
    }
    public TrieNode getNode(Character c){
        return nodes[c-'a'];
    }
}

