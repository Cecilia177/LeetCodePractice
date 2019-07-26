import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target == 0 || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        combinationSub(candidates, target, new ArrayList<>(), 0);
        return results;
    }

    private void combinationSub(int[] candidates, int target, List<Integer> sub, int start) {
        if(target == 0) {
            results.add(new ArrayList<>(sub));
            return;          //回溯点1
        }
        if(target < 0) {
            return;          //回溯点2
        }
        for(int i = start; i < candidates.length; i++) {
            if(target >= candidates[i]) {
                sub.add(candidates[i]);
                combinationSub(candidates, target - candidates[i], sub, i);
                sub.remove(sub.size() - 1);
            }
        }
        return;              //回溯点3
    }
}

class CombinationSumTest {
    public void test() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> results = new CombinationSum().combinationSum(candidates, target);
        for(List<Integer> result : results) {
            System.out.print(result + " ");
        }
    }
}
