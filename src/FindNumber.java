public class FindNumber {
    public boolean find(int target, int [][] array) {
        if(array.length == 0) {
            return false;
        }
        int row;
        for(row = 0; row < array.length; row++) {
            if(target < array[row][0]) {
                break;
            }
        }
        if(row == 0) {
            return false;
        }
        int column;
        for(column = 0; column < array[0].length; column++) {
            if(target < array[0][column]) {
                break;
            }
        }
        if(column == 0) {
            return false;
        }
        System.out.println("row: " + row);
        System.out.println("column: " + column);
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(target == array[i][j]) {
                    return true;
                }
                if(target < array[i][j]) {
                    break;
                }
            }
        }
        return false;

    }


}

class FindNumberTest {
    public void test() {

        int[][] array = new int[][]{new int[]{1,2,8,9}, new int[]{2,4,9,12}, new int[]{4,7,10,13}, new int[]{6,8,11,15}};
        int target = 7;
        System.out.println(new FindNumber().find(target, array));
    }
}