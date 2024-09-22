public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str: strs){
            sb.append(str);
            sb.append("_SSRK_");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] arrays_str=s.split("_SSRK_", -1);
        return Arrays.asList(arrays_str).subList(0, arrays_str.length-1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));