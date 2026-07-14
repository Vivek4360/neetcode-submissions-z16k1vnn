from collections import defaultdict

class CountSquares:

    def __init__(self):
        self.points = defaultdict(lambda: defaultdict(int))

    def add(self, point):
        x, y = point
        self.points[x][y] += 1

    def count(self, point):
        x, y = point

        if x not in self.points:
            return 0

        result = 0

        for ny, freq in self.points[x].items():

            if ny == y:
                continue

            side = ny - y

            # Right square
            result += (
                freq *
                self.points[x + side].get(y, 0) *
                self.points[x + side].get(ny, 0)
            )

            # Left square
            result += (
                freq *
                self.points[x - side].get(y, 0) *
                self.points[x - side].get(ny, 0)
            )

        return result