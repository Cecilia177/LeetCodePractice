public class MaxRectangular2 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        /*逐行遍历matrix，对于每行，逐列遍历每个元素，更新arr在该列的值*/
        int[] arr = new int[matrix[0].length];
        int max = 0;
        MaxRectangular maxRectangular = new MaxRectangular();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[j] = matrix[i][j] == '1' ? (arr[j] + 1) : 0;
            }
            max = Math.max(max, maxRectangular.largestRectangleArea(arr));
        }
        return max;
    }


}
