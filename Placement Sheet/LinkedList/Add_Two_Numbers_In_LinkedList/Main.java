package Add_Two_Numbers_In_LinkedList;

public class Main {
    Node head = null;
    Node tail = null;

    private void insert(int data) {
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

    private void display() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    private static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    private static Node addTwoNumNode(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        head1 = reverseList(head1);
        head2 = reverseList(head2);

        Node dummyNode = new Node(-1);
        Node tempNode = dummyNode;

        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            int digit = sum % 10;
            carry = sum / 10;

            tempNode.next = new Node(digit);
            tempNode = tempNode.next;
        }

        return reverseList(dummyNode.next);

    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Main list1 = new Main();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        System.out.print("List 1: ");
        list1.display();

        Main list2 = new Main();
        list2.insert(4);
        list2.insert(5);
        list2.insert(6);
        System.out.print("List 2: ");
        list2.display();

        Node newHead = addTwoNumNode(list1.head, list2.head);
        display(newHead);
    }
}
