import java.util.*; // For Random and Stack

class Skiplist {
    // Node class for skiplist
    class Node {
        int val;     // Value stored in the node
        Node next;   // Pointer to the next node in the same level
        Node down;   // Pointer to the node in the level below

        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }

    Node head = new Node(-1, null, null); // Initial head of the top level
    Random rand = new Random();           // Random generator for coin flips

    // Constructor
    public Skiplist() {
        // Head is already initialized to empty level
    }

    // Search for a target value in the skiplist
    public boolean search(int target) {
        Node cur = head; // Start from top-level head
        // Traverse levels top to bottom
        while (cur != null) {
            // Move right in current level while next value is less than target
            while (cur.next != null && cur.next.val < target) {
                cur = cur.next;
            }
            // If next value matches target, found it
            if (cur.next != null && cur.next.val == target) {
                return true;
            }
            // Move down one level
            cur = cur.down;
        }
        // Not found
        return false;
    }

    // Add a number to the skiplist
    public void add(int num) {
        Stack<Node> stack = new Stack<>(); // Stack to remember path where new nodes may be inserted
        Node cur = head;

        // Step 1: Traverse all levels and push potential insert positions
        while (cur != null) {
            // Move right while next value is less than num
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            stack.push(cur); // Push current position for possible insertion
            cur = cur.down;  // Move down one level
        }

        boolean insert = true; // To decide whether to insert in higher level
        Node down = null;      // To connect down pointer of upper-level node to lower-level node

        // Step 2: Insert new node(s) into appropriate levels, based on random coin flip
        while (insert && !stack.isEmpty()) {
            cur = stack.pop(); // Get position to insert at current level
            // Insert node: new node points to cur.next, and down points to lower level node
            cur.next = new Node(num, cur.next, down);
            down = cur.next;   // Update down to newly inserted node for next upper level
            insert = rand.nextDouble() < 0.5; // Flip a coin: continue if heads (probability 0.5)
        }

        // Step 3: If still need to insert after topmost level, create a new level
        if (insert) {
            head = new Node(-1, null, head); // New head at new top level, pointing down to old head
        }
    }

    // Erase (delete) a number from the skiplist
    public boolean erase(int num) {
        Node cur = head;  // Start from top-level head
        boolean found = false; // Flag to check if num was found and deleted

        // Traverse levels from top to bottom
        while (cur != null) {
            // Move right while next value is less than num
            while (cur.next != null && cur.next.val < num) {
                cur = cur.next;
            }
            // If next value equals num, delete it by bypassing
            if (cur.next != null && cur.next.val == num) {
                found = true;
                cur.next = cur.next.next; // Bypass the node to delete it
            }
            cur = cur.down; // Move down to next level
        }
        return found; // Return whether deletion was successful
    }
}
