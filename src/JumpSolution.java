import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class JumpSolution {

    /*
    * 1. 从左至右jump
    * 2. 每到达一个格子（设其中的值为k），遍历从1~k能到达的格子，将格子放入currentpositions中保存，此步视为一层遍历，i++
    * 3. 某层遍历时，格子序号超出最大序号，则此时i值为最小跳跃数
    * */
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        List<Integer> currentPositions = new ArrayList<>();
        currentPositions.add(0);
        Set<Integer> closed = new HashSet<>();
        int currentPosition;
        int level = 1;

        while (true) {
            List<Integer> newPositions = new ArrayList<>();
            for(Integer position : currentPositions) {
                for(int i = 1; i <= nums[position]; i++) {
                    currentPosition = position + i;
                    //System.out.println("current position: " + currentPosition);
                    if(currentPosition >= nums.length - 1) {
                        return level;
                    }
                    if(!closed.contains(currentPosition)) {
                        newPositions.add(currentPosition);
                        closed.add(currentPosition);
                    }

                }
            }
            level ++;
            currentPositions = newPositions;
        }
    }
}
