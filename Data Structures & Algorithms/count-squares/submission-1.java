

class CountSquares {

    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = points.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!points.containsKey(x)) {
            return 0;
        }

        int result = 0;
        Map<Integer, Integer> yMap = points.get(x);

        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            int ny = entry.getKey();
            int freq = entry.getValue();

            if (ny == y) continue;

            int side = ny - y;

            // Right square
            result += freq *
                    points.getOrDefault(x + side, Collections.emptyMap())
                          .getOrDefault(y, 0) *
                    points.getOrDefault(x + side, Collections.emptyMap())
                          .getOrDefault(ny, 0);

            // Left square
            result += freq *
                    points.getOrDefault(x - side, Collections.emptyMap())
                          .getOrDefault(y, 0) *
                    points.getOrDefault(x - side, Collections.emptyMap())
                          .getOrDefault(ny, 0);
        }

        return result;
    }
}