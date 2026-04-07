class LRUCache(capacity: Int) {
    
   
    private class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
    
    private val capacity: Int
    private val cache: HashMap<Int, Node> = HashMap()
    private val head: Node  
    private val tail: Node  
    
    init {
        this.capacity = capacity
        
        this.head = Node(-1, -1)
        this.tail = Node(-1, -1)
        head.next = tail
        tail.prev = head
    }
    
    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        
        
        moveToHead(node)
        return node.value
    }
    
    fun put(key: Int, value: Int) {
        val existingNode = cache[key]
        
        if (existingNode != null) {
           
            existingNode.value = value
            moveToHead(existingNode)
            return
        }
        
        
        if (cache.size == capacity) {
            removeLRU()
        }
        
        
        val newNode = Node(key, value)
        cache[key] = newNode
        addToHead(newNode)
    }
    
    
    private fun addToHead(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }
    
    
    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }
    
    
    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }
    
   
    private fun removeLRU() {
        val lru = tail.prev ?: return
        removeNode(lru)
        cache.remove(lru.key)
    }
}