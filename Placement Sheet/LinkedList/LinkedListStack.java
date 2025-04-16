public class LinkedListStack {
    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        int getData() {
            return data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node node) {
            this.next = node;
        }
    }

    private Node top = null;
    private Node start = null;

    // Push...
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            start = newNode;
        } else {
            top.setNext(newNode);
        }
        top = newNode;
    }

    // Peek...
    public void peek() {
        if (top == null) {
            System.out.println("Stack is empty...");
            return;
        }
        System.out.println("Top element: " + top.getData());
    }

    // Pop...
    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty...");
            return;
        }
        int value = top.getData();

        // Single element case
        if (start == top) {
            start = null;
            top = null;
        } else {
            Node currNode = start;
            while (currNode.getNext() != top) {
                currNode = currNode.getNext();
            }
            currNode.setNext(null);
            top = currNode;
        }

        System.out.println("Popped element: " + value);
    }

    // Display...
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty...");
            return;
        }
        Node currNode = start;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        while (currNode != null) {
            stack.push(currNode.getData());
            currNode = currNode.getNext();
        }

        while (!stack.isEmpty()) {
            System.out.println("|" + stack.pop() + "|");
        }
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.peek();
        stack.pop();
        stack.peek();
        stack.display();
    }
}