class MyQueue {
    Stack<Integer> s1, s2;
    int front;
    public MyQueue() {
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
        front=-1;
    }
    
    public void push(int x) {
        if(s1.empty()){
            front=x;
        }
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int toReturn=s2.empty()?-1:s2.pop();
        front=!s2.empty()?s2.peek():-1;
        //let's transfer back
        while(!s2.empty()){
            s1.push(s2.pop());
        }       
        return toReturn;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */