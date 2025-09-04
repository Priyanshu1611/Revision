import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private int size;
    private final Map<Integer, Node> map;
    private final Node head; // sentinel head (MRU side)
    private final Node tail; // sentinel tail (LRU side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity * 2);

        // sentinels
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        Node fresh = new Node();
        fresh.key = key;
        fresh.value = value;
        map.put(key, fresh);
        addAfterHead(fresh);
        size++;

        if (size > capacity) {
            Node lru = popTail();
            map.remove(lru.key);
            size--;
        }
    }

    // --- helpers ---

    private void moveToHead(Node node) {
        removeNode(node);
        addAfterHead(node);
    }

    private void addAfterHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }

    private Node popTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node() {}
}
