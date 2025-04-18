public class DeleteWithOutHead {
    public static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;

    // Insert...
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
        tail = newNode;
    }

    // Display...
    public void display() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.getData() + " --> ");
            currNode = currNode.getNext();
        }
        System.out.println("Null");
    }

    // Find node...
    public Node findNode(int data) {
        if (head == null) {
            System.out.println("List is empty...");
            return null;
        }
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getData() == data) {
                return currNode;
            }
            currNode = currNode.getNext();
        }
        return null;
    }

    // Delete without head...
    public static void deleteWithOutHead(Node node) {
        if (node == null || node.getNext() == null) {
            System.out.println("Cannot delete the last node or a null node without head.");
            return;
        }
        Node nextNode = node.getNext();
        node.setData(nextNode.getData());
        node.setNext(nextNode.getNext());
    }

    public static void main(String[] args) {
        DeleteWithOutHead list = new DeleteWithOutHead();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        System.out.print("Before remove: ");
        list.display();
        System.out.println("After remove: ");
        Node findNode = list.findNode(4);
        if (findNode != null) {
            deleteWithOutHead(findNode);
        }
        list.display();
    }
}
