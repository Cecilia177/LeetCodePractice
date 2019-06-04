public class MissingPositive {

/*给定一个未排序的整数数组，找出其中没有出现的最小的正整数。*/
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }

        int[] arr = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= nums.length && nums[i] > 0) {
                arr[nums[i]] = nums[i];
            }
        }
        printArr(arr);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != i) {
                return i;
            }
        }
        return arr.length;

    }

    private void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

class MissingPositiveTest {
    public void test() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{3,4,-1,1};
        int[] nums3 = new int[]{7,8,9,11,12};

        MissingPositive missingPositive = new MissingPositive();
        System.out.println(missingPositive.firstMissingPositive(nums1));
        System.out.println(missingPositive.firstMissingPositive(nums2));
        System.out.println(missingPositive.firstMissingPositive(nums3));
    }
}
