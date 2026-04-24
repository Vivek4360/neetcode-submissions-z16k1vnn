

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>())
                 .add(new int[]{t[1], t[2]});
        }

        // Step 2: Min heap (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, k});

        // Step 3: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (time > dist[node]) continue;

            if (graph.containsKey(node)) {
                for (int[] nei : graph.get(node)) {
                    int next = nei[0];
                    int t = nei[1];

                    if (time + t < dist[next]) {
                        dist[next] = time + t;
                        pq.offer(new int[]{dist[next], next});
                    }
                }
            }
        }

        // Step 5: Find max time
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}