import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || target == 0) {
            return results;
        }
        Arrays.sort(candidates);
        combinationSub(candidates, target, new ArrayList<>(), candidates[candidates.length - 1] + 1, 0);
        return results;

    }

    private void combinationSub(int [] candidates, int target, ArrayList<Integer> sub, int temp, int start) {
        if(target == 0) {
            results.add(new ArrayList<>(sub));
            return;            //回溯点1
        }
        if(target < 0) {
            return;            //回溯点2
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] != temp) {
                sub.add(candidates[i]);
                combinationSub(candidates, target - candidates[i], sub, temp, i + 1);
                temp = candidates[i];
                sub.remove(sub.size() - 1);
            }
        }
        return;                //回溯点3

    }



}

class CombinationSumTest2 {
    public void test() {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> results = new CombinationSum2().combinationSum2(candidates, target);
        for(List<Integer> result : results) {
            System.out.print(result + " ");
        }
    }
}
