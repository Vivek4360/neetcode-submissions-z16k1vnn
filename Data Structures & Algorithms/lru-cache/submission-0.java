class LRUCache {
    
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private java.util.HashMap<Integer, Node> cache;
    private Node head;  
    private Node tail;  
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.HashMap<>();
        
        
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        
        
        if (cache.size() == capacity) {
            removeLRU();
        }
        
        
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
    }
    
    
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
   
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    
    private void removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        cache.remove(lru.key);
    }
}