import java.util.ArrayList;
import java.util.List;

public class Permutation {
    //一个不含重复元素的数组，返回所有的可能排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        getPermutation(result, nums, new ArrayList<>(), flag);
        return result;
    }

    private void getPermutation(List<List<Integer>> result, int[] nums, List<Integer> tempList, boolean[] flag) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(flag[i] == true) {
                continue;
            }
//            List<Integer> newList = new ArrayList<>();
//            listCopy(tempList, newList);
//            newList.add(nums[i]);
            tempList.add(nums[i]);
            flag[i] = true;
            getPermutation(result, nums, tempList, flag);
            flag[i] = false;
            tempList.remove(tempList.size() - 1);
        }
        return;

    }
    public void listCopy(List<Integer> source, List<Integer> target) {
        for(int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
    }
}

class PermutationTest {
    public void test() {
        Permutation permutation = new Permutation();
        int[] nums = new int[]{1, 1, 3};
        for(List<Integer> list : permutation.permute(nums)) {
            System.out.println(list);
        }
//        System.out.println(permutation.permute(nums));
    }
}
