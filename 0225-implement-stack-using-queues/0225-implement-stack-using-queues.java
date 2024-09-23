class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
        top=-1;
    }
    
    public void push(int x) {
        q1.offer(x);
        top=x;
    }
    
    public int pop() {
        if(!q1.isEmpty()){
        while(q1.size()!=1){
            top=q1.poll();
            q2.offer(top);
        }
        int poll=q1.poll();
        // top=-1;
        // while(q2.size()!=0){
        //     if(q2.size()==1){
        //         top=q2.peek();
        //     }
        //     q1.offer(q2.poll());
        // }
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return poll;
        }else{
            return -1;
        }
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */