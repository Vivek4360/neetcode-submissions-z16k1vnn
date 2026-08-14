public class Solution {
    public String kthDistinct(String[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;

                if (arr[i].equals(arr[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                k--;
                if (k == 0) {
                    return arr[i];
                }
            }
        }
        return "";
    }
}