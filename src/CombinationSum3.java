import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n <= k) {
            return results;
        }
        getResult(k, n, 1, new ArrayList<>());
        return results;
    }

    private void getResult(int k, int sum, int start, List<Integer> tempResult) {
        if(tempResult.size() == k && sum == 0) {
            results.add(new ArrayList<>(tempResult));
            return;
        }
        if(sum <= k - tempResult.size()) {
            return;
        }
        if(sum < 0) {
            return;
        }

        for(int i = start; i <= 9 ; i++) {
            tempResult.add(i);
            getResult(k, sum - i, i + 1, tempResult);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}

class CombinationSum3Test {
    public void test() {
        List<List<Integer>> results = new CombinationSum3().combinationSum3(3, 9);

        for(List<Integer> result : results) {
            System.out.println(result);
        }
    }
}