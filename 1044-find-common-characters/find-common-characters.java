class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        int[] freq = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
                freq[i]=0;
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        return result;
    }
}