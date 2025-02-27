class FlatteningNode {
    int data;
    FlatteningNode next;
    FlatteningNode bottom;

    FlatteningNode(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }

}

public class FlatteningLinkList{
    // Merge two sorted linkedlist...
    FlatteningNode merge(FlatteningNode a, FlatteningNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        FlatteningNode result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        return result;
    }

    FlatteningNode flatten(FlatteningNode root) {
        if(root == null || root.next == null) return root;
        root.next = flatten(root.next);

        root = merge(root, root.next);
        return root;
    }

    void printList(FlatteningNode root) {
        while (root != null) {
            System.out.print(root.data + " --> ");
            root = root.bottom;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        FlatteningLinkList list = new FlatteningLinkList();
        FlatteningNode root = new FlatteningNode(5);
        root.bottom = new FlatteningNode(7);
        root.bottom.bottom = new FlatteningNode(8);
        root.bottom.bottom.bottom = new FlatteningNode(30);

        root.next = new FlatteningNode(10);
        root.next.bottom = new FlatteningNode(20);

        root.next.next = new FlatteningNode(19);
        root.next.next.bottom = new FlatteningNode(22);
        root.next.next.bottom.bottom = new FlatteningNode(50);

        root.next.next.next = new FlatteningNode(28);
        root.next.next.next.bottom = new FlatteningNode(35);
        root.next.next.next.bottom.bottom = new FlatteningNode(40);
        root.next.next.next.bottom.bottom.bottom = new FlatteningNode(45);

        root = list.flatten(root);
        list.printList(root);
    }
}
