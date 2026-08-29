class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        if rowIndex == 0:
            return [1]

        curRow = [1]
        prevRow = self.getRow(rowIndex - 1)

        for i in range(1, rowIndex):
            curRow.append(prevRow[i - 1] + prevRow[i])

        curRow.append(1)
        return curRow