class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:

        m = len(matrix)
        n = len(matrix[0])

        rows = [False] * m
        cols = [False] * n

        # First Pass
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    rows[i] = True
                    cols[j] = True

        # Second Pass
        for i in range(m):
            for j in range(n):
                if rows[i] or cols[j]:
                    matrix[i][j] = 0
        
        