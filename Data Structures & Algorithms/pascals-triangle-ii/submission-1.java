public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Arrays.asList(1);

        List<Integer> curRow = new ArrayList<>(Arrays.asList(1));
        List<Integer> prevRow = getRow(rowIndex - 1);

        for (int i = 1; i < rowIndex; i++) {
            curRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        curRow.add(1);
        return curRow;
    }
}