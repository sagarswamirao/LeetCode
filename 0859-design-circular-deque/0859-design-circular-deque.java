// class MyCircularDeque {

//     int[] arrayDeque;
//     int front;
//     int rear;
//     int max_size;
//     int elements_count;

//     public MyCircularDeque(int k) {
//         max_size = k;
//         arrayDeque = new int[max_size];
//         front = 0;
//         rear = -1;  // rear starts at -1 since there's no element initially
//         elements_count = 0;
//     }

//     // Insert value at the front of deque
//     public boolean insertFront(int value) {
//         if (isFull()) return false;  // Check if deque is full
//         front = (front - 1 + max_size) % max_size;  // Move front backward in circular manner
//         arrayDeque[front] = value;
//         elements_count++;
//         return true;
//     }

//     // Insert value at the rear of deque
//     public boolean insertLast(int value) {
//         if (isFull()) return false;  // Check if deque is full
//         rear = (rear + 1) % max_size;  // Move rear forward in circular manner
//         arrayDeque[rear] = value;
//         elements_count++;
//         return true;
//     }

//     // Delete value from the front of deque
//     public boolean deleteFront() {
//         if (isEmpty()) return false;  // Check if deque is empty
//         front = (front + 1) % max_size;  // Move front forward in circular manner
//         elements_count--;
//         return true;
//     }

//     // Delete value from the rear of deque
//     public boolean deleteLast() {
//         if (isEmpty()) return false;  // Check if deque is empty
//         rear = (rear - 1 + max_size) % max_size;  // Move rear backward in circular manner
//         elements_count--;
//         return true;
//     }

//     // Get the front item from the deque
//     public int getFront() {
//         if (isEmpty()) return -1;  // If deque is empty, return -1
//         return arrayDeque[front];
//     }

//     // Get the last item from the deque
//     public int getRear() {
//         if (isEmpty()) return -1;  // If deque is empty, return -1
//         return arrayDeque[rear];
//     }

//     // Check whether the deque is empty
//     public boolean isEmpty() {
//         return elements_count == 0;
//     }

//     // Check whether the deque is full
//     public boolean isFull() {
//         return elements_count == max_size;
//     }
// }

class MyCircularDeque {

    int[] arrayDeque;
    int front=0;
    int rear=-1;
    int max_index_value;
    int elements_count=0;
    public MyCircularDeque(int k) {
        arrayDeque=new int[k];
        max_index_value=k;
    }
    
    public boolean insertFront(int value) {
        if(elements_count==max_index_value) return false;
        front=Math.abs(front-1+max_index_value)%max_index_value;
        arrayDeque[front]=value;
        if (isEmpty()) {
            rear = front;
        }
        elements_count+=1;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(elements_count==max_index_value) return false;
        rear=Math.abs(rear+1)%max_index_value;
        arrayDeque[rear]=value;
        elements_count+=1;
        return true;
    }
    
    public boolean deleteFront() {
        if(elements_count==0) return false;
        arrayDeque[front]=0;
        front=Math.abs(front+1)%max_index_value;
        elements_count-=1;
        return true;
    }
    
    public boolean deleteLast() {
        if(elements_count==0) return false;
        arrayDeque[rear]=0;
        rear=Math.abs(rear-1+max_index_value)%max_index_value;
        elements_count-=1;
        return true;
    }
    
    public int getFront() {
        if(elements_count==0) return -1;
        return arrayDeque[front];
    }
    
    public int getRear() {
        if(elements_count==0) return -1;
        return arrayDeque[rear];
    }
    
    public boolean isEmpty() {
        return elements_count==0;
    }
    
    public boolean isFull() {
        return elements_count==max_index_value;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */