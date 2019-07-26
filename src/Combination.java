import java.util.ArrayList;
import java.util.List;

public class Combination {

    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(k > n) {
            return results;
        }
        getSubCombination(n, k, 1, new ArrayList<>());
        return results;
    }

    private void getSubCombination(int n, int k, int start, ArrayList<Integer> sub) {
        if(k == 0) {
            results.add(new ArrayList<>(sub));
            System.out.println(" sub : " + sub);
            return;
        }
        for(int i = start; i <= n - k + 1; i++) {
            sub.add(i);
            getSubCombination(n, k - 1, i + 1, sub);
            sub.remove(sub.size() - 1);
        }
        return;
    }
}

class CombinationTest {
    public void test() {
        List<List<Integer>> results = new Combination().combine(4, 2);
        for(List<Integer> result : results) {
            System.out.print(result + " ");
        }
    }
}