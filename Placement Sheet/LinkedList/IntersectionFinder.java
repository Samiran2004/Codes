/**
 * Q: Intersection point of two Linked Lists
 */

public class IntersectionFinder {
    private Node headA;
    private Node headB;

    // Node class
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertListA(int data) {
        headA = insertNode(headA, data);
    }

    public void insertListB(int data) {
        headB = insertNode(headB, data);
    }

    // insertNode
    public Node insertNode(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
        return head;
    }

    public void display(Node head) {
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

    // Intersection finder
    public void findIntersection() {
        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        if (a != null) {
            System.out.println("Intersection found at node with data: " + a.data);
        } else {
            System.out.println("No intersection found...");
        }
    }

    public static void main(String[] args) {
        IntersectionFinder list = new IntersectionFinder();

        // Using fully qualified name to access static inner class Node
        IntersectionFinder.Node common = new IntersectionFinder.Node(8);
        common.next = new IntersectionFinder.Node(10);

        // Create List A: 1 -> 2 -> 3 -> 8 -> 10
        list.headA = new IntersectionFinder.Node(1);
        list.headA.next = new IntersectionFinder.Node(2);
        list.headA.next.next = new IntersectionFinder.Node(3);
        list.headA.next.next.next = common;

        // Create List B: 6 -> 8 -> 10
        list.headB = new IntersectionFinder.Node(6);
        list.headB.next = common;

        System.out.println("List A:");
        list.display(list.headA);
        System.out.println("List B:");
        list.display(list.headB);

        list.findIntersection(); // ✅ fixed method name
    }
}

/**
 * 
 * ---
 * 
 * ## ✅ `findIntersection()` Method (Finds where two linked lists intersect)
 * 
 * ```java
 * public void findIntersection() {
 * ```
 * - This method is called to find the intersection point (common node) of two
 * linked lists — `headA` and `headB`.
 * 
 * ```java
 * Node a = headA;
 * Node b = headB;
 * ```
 * - `a` starts from the beginning of List A.
 * - `b` starts from the beginning of List B.
 * 
 * ```java
 * while (a != b) {
 * a = (a == null) ? headB : a.next;
 * b = (b == null) ? headA : b.next;
 * }
 * ```
 * - This loop keeps moving both `a` and `b` forward by one node.
 * - If either `a` or `b` reaches the end (`null`), we **reset it to the other
 * list's head**.
 * - This helps align both pointers to meet at the intersection point after at
 * most `lengthA + lengthB` steps.
 * - The loop exits only when:
 * - `a == b` → either both point to the intersection node, or both are `null`
 * (no intersection).
 * 
 * ```java
 * if (a != null) {
 * System.out.println("Intersection found at node with data: " + a.data);
 * } else {
 * System.out.println("No intersection found...");
 * }
 * ```
 * - If `a` is not `null`, it means the intersection node was found — we print
 * its data.
 * - Otherwise, the lists do not intersect.
 * 
 * ---
 * 
 * ## ✅ `main()` Method (Sets up the test data and calls the method)
 * 
 * ```java
 * public static void main(String[] args) {
 * IntersectionFinder list = new IntersectionFinder();
 * ```
 * - Entry point of the program.
 * - We create an object `list` of `IntersectionFinder` class to use its methods
 * and nodes.
 * 
 * ```java
 * IntersectionFinder.Node common = new IntersectionFinder.Node(8);
 * common.next = new IntersectionFinder.Node(10);
 * ```
 * - We create a **shared part** of both lists (nodes `8 -> 10`) that represents
 * the intersection.
 * - Both lists will eventually point to this same segment.
 * 
 * ### 🔗 Create List A: 1 → 2 → 3 → 8 → 10
 * ```java
 * list.headA = new IntersectionFinder.Node(1);
 * list.headA.next = new IntersectionFinder.Node(2);
 * list.headA.next.next = new IntersectionFinder.Node(3);
 * list.headA.next.next.next = common;
 * ```
 * - First 3 nodes are created normally.
 * - Then, we connect the `3rd node` to the shared `common` part (8 → 10).
 * 
 * ### 🔗 Create List B: 6 → 8 → 10 (starting from 6, then intersect)
 * ```java
 * list.headB = new IntersectionFinder.Node(6);
 * list.headB.next = common;
 * ```
 * - First node is `6`.
 * - Then we link it directly to the shared part (8 → 10).
 * 
 * ### 🖨 Print Both Lists
 * ```java
 * System.out.println("List A:");
 * list.display(list.headA);
 * System.out.println("List B:");
 * list.display(list.headB);
 * ```
 * - Show both lists before searching for intersection.
 * 
 * ### 🚀 Call the Intersection Finder
 * ```java
 * list.findIntersection();
 * ```
 * - Finally, we call the method to find and print the intersection.
 * 
 * ---
 * 
 * ## 🔚 Output for this code
 * 
 * ```
 * List A:
 * 1 --> 2 --> 3 --> 8 --> 10 --> NULL
 * List B:
 * 6 --> 8 --> 10 --> NULL
 * Intersection found at node with data: 8
 * ```
 * 
 * ---
 */