package Implement_Stack_With_Linked_List;

public class Stack {

    private LinkedList list;

    Stack() {
        list = new LinkedList();
    }

    public void push(int data) {
        list.insert(data);
    }

    public int pop() {
        return list.removeEnd();
    }

    public int top() {
        return list.getTailData();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.getSize();
    }
}
