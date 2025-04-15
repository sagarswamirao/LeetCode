class TrieNode:
    def __init__(self):
        self.nodes=[None]*26
        self.is_end=False
    
    def mark_end(self):
        self.is_end=True
    
    def is_word_end(self):
        return self.is_end

    def __get_chr_idx(self,chr):
        return ord(chr)-ord('a')

    def set_node(self,character,trie_node):
        self.nodes[self.__get_chr_idx(character)]=trie_node
    
    def get_node(self, character):
        return self.nodes[self.__get_chr_idx(character)]
    
    def is_character_present(self, character):
        return True if self.get_node(character) is not None else False
class Trie:

    def __init__(self):        
        self.root=TrieNode()        

    def insert(self, word: str) -> None:
        curr_head=self.root
        for character in word:
            if not curr_head.is_character_present(character):
                curr_head.set_node(character, TrieNode())
            curr_head=curr_head.get_node(character)
        curr_head.mark_end()

    def search(self, word: str) -> bool:
        curr_head=self.root
        for character in word:
            if not curr_head.is_character_present(character):
                return False
            curr_head=curr_head.get_node(character)
        return curr_head.is_word_end()

    def startsWith(self, prefix: str) -> bool:
        curr_head=self.root
        for character in prefix:
            if not curr_head.is_character_present(character):
                return False
            curr_head=curr_head.get_node(character)
        return True       


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)