class Solution {
    fun rotate(matrix: Array<IntArray>) {

        val n = matrix.size


        for(i in 0 until n){
            for(j in i + 1 until n){

                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp

            }
        }
        for(row in matrix){
            row.reverse()
        }


     



    }
}
