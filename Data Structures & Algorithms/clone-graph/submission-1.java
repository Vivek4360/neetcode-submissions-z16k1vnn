/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// BFS

/*class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // start
        q.add(node);
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node neighbor : curr.neighbors) {

                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}
*/

// DFS

class Solution {
    
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        // Step 1: base case
        if (node == null) return null;
        
        // Step 2: if already cloned
        if (map.containsKey(node)) return map.get(node);
        
        // Step 3: create new node
        Node clone = new Node(node.val);
        
        // Step 4: store in map
        map.put(node, clone);
        
        // Step 5: clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}