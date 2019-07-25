import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutation {
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);
        getOnePermutation(nums, flag, new ArrayList<>());
        return results;
    }

    private void getOnePermutation(int[] nums, boolean[] flag, List<Integer> permutation) {

        int record = nums[nums.length - 1] + 1;
        if(permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));

            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(flag[i] == false  && record !=nums[i]) {
                flag[i] = true;
                permutation.add(nums[i]);
                record = nums[i];
                getOnePermutation(nums, flag, permutation);
                permutation.remove(permutation.size() - 1);
                flag[i] = false;
            }
        }
        return;
    }

}

class UniquePermutationTest {
    public void test() {
        int[] nums = new int[]{3, 3, 0, 3};
        List<List<Integer>> results = new UniquePermutation().permuteUnique(nums);
        for(List<Integer> result : results) {
            System.out.println(result);
        }
    }

}