class Solution {
    // Tasks can be completed in any order,
    // but there's a constraint: there has to be a gap of at least n 
    // intervals between two tasks with the same label.
    // public int leastInterval(char[] tasks, int n) {
    //     int[] freq=new int[26];
    //     int maxCount=0;
    //     for(char task:tasks){
    //         freq[task-'A']++;
    //         maxCount = Math.max(maxCount, freq[task - 'A']);
    //     }
    //     int time = (maxCount - 1) * (n + 1);
    //     for (int f : freq) {
    //         if (f == maxCount) {
    //             time++;
    //         }
    //     }
    //     return Math.max(tasks.length, time); 
    // }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq=new HashMap<>();
        Queue<int[]> waitingQueue=new LinkedList<>();  //{task_freq, time_to_unfreeze_at}
        PriorityQueue<Integer> taskMapHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(char task:tasks){
            freq.put(task, freq.getOrDefault(task, 0)+1);
        }
        int time = 0;
        taskMapHeap.addAll(freq.values());
        while(!taskMapHeap.isEmpty() || !waitingQueue.isEmpty()){
            time+=1;
            if(!taskMapHeap.isEmpty()){
                Integer task_freq=taskMapHeap.poll()-1;
                if(task_freq>0){
                    waitingQueue.offer(new int[]{task_freq, (time+n)});
                }
            }
            if(!waitingQueue.isEmpty() && waitingQueue.peek()[1]==time){
                taskMapHeap.offer(waitingQueue.poll()[0]);
            }      
        }
        return time; 
    }
}