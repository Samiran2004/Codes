public class MergeSortedLinkedList {
    private Node head = null;
    private Node tail = null;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    void display(Node root) {
        if (root == null) {
            System.out.println("List is empty...");
            return;
        }
        Node currNode = root;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    Node mergeTwoSortedList(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node currNode = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                currNode.next = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                list2 = list2.next;
            }
            currNode = currNode.next;
        }

        if (list1 != null) {
            currNode.next = list1;
        } else {
            currNode.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeSortedLinkedList list1 = new MergeSortedLinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        System.out.println("List1: ");
        list1.display();

        MergeSortedLinkedList list2 = new MergeSortedLinkedList();
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);
        list2.insert(9);
        System.out.println("List2: ");
        list2.display();

        MergeSortedLinkedList result = new MergeSortedLinkedList();
        Node newHead = result.mergeTwoSortedList(list1.head, list2.head);
        
        System.out.println("Merged List: ");
        result.display(newHead);
    }
}