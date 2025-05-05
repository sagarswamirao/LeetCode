class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() &&  temperatures[i]> temperatures[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}