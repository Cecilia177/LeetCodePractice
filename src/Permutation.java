import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    //一个不含重复元素的数组，返回所有的可能排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutation(result, nums, new ArrayList<Integer>());

        return result;
    }

    private void getPermutation(List<List<Integer>> result, int[] nums, List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            result.add(tempList);
//            System.out.println(Arrays.toString());
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(tempList.contains(nums[i])) {
                continue;
            }

            tempList.add(nums[i]);
            getPermutation(result, nums, tempList);
        }
        return;

    }
}

class PermutationTest {
    public void test() {
        Permutation permutation = new Permutation();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permutation.permute(nums));
    }
}
