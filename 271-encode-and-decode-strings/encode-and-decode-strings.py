class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        res=[]
        for stri in strs:
            res.append(str(len(stri))+'#'+stri)

        return ''.join(res)
        

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        res=[]
        i=0

        while i<len(s):
            j=i
            while s[j]!='#': #getting the length of next string to read
                j+=1
            
            length_of_string=int(s[i:j]) #parse that string to int, to get the value
            # j is #, so we want the string starting after it, until the length_of_string
            res.append(s[j+1: j+1+length_of_string]) 
            # we have extracted till j+1, str_length, now the next length
            i = j + 1 + length_of_string
        
        return res


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))