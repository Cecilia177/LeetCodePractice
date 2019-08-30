import java.util.*;

public class FrogCrossRiver {
    public boolean canCross(int[] stones) {
        //position中保存（每个石子所在位置：从当前石子可跳距离的列表）键值对
        Map<Integer, TreeSet<Integer>> position = new LinkedHashMap<>();
        for(int i = 0; i < stones.length; i++) {
            TreeSet<Integer> steps = new TreeSet<>();
            position.put(stones[i], steps);
        }

        position.get(stones[0]).add(1);
//        Iterator<Integer> iterator = position.keySet().iterator();
        for(int i = 0; i < stones.length; i++) {
            int currentPos = stones[i];
            TreeSet<Integer> steps = position.get(currentPos);
            Iterator<Integer> it = steps.iterator();

            while(it.hasNext()) {   //i为从currentPos可跳的步数
                int j = it.next();
                if(position.containsKey(currentPos + j)) {
                    if(j > 1) {
                        position.get(currentPos + j).add(j - 1);
                    }
                    if(j > 0) {
                        position.get(currentPos + j).add(j);
                    }
                    position.get(currentPos + j).add(j + 1);

                }
//                System.out.println(currentPos + j + " " + position.get(currentPos + j));
            }

        }
//        System.out.println(position.get(stones[stones.length - 1]));
        return position.get(stones[stones.length - 1]).size() != 0;

    }
}

class FrogCrossRiverTest {
    public void test() {
        int[] stones = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(new FrogCrossRiver().canCross(stones));
    }
}