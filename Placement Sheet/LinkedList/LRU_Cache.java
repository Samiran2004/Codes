import java.util.HashMap;

class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class LRU_Cache {
    private final int capacity;
    private int count;
    private final HashMap<Integer, DNode> cache;
    private DNode head, tail;

    LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.cache = new HashMap<>();
        this.head = new DNode(-1);
        this.tail = new DNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    // Add a node to the tail (most recently used)
    private void addToTail(DNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    // Remove a node from the linked list
    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert an item into the LRU Cache
    public void insert(int data) {
        if (cache.containsKey(data)) {
            DNode existingNode = cache.get(data);
            removeNode(existingNode);
            addToTail(existingNode);
        } else {
            DNode newNode = new DNode(data);
            cache.put(data, newNode);
            addToTail(newNode);
            count++;

            if (count > capacity) {
                DNode lruNode = head.next;
                removeNode(lruNode);
                cache.remove(lruNode.data);
                count--;
            }
        }
    }

    // Display LRU Cache
    public void display() {
        DNode curr = head.next;
        while (curr != tail) {
            System.out.print(curr.data + " <--> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(4);
        cache.insert(1);
        cache.insert(2);
        cache.insert(3);
        cache.display();
        cache.insert(4);
        cache.display();
        cache.insert(5);
        cache.display();
    }
}