public class FindKthLargest {
    /*注意考虑nums中元素为负数的情况*/
    public int find(int nums[], int k) {

        int max = 0;
        int min = 0;
        for(int i = 0; i < nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        int[] arrPositive = new int[max + 1];
        int[] arrNegative = new int[-min + 1];
        for(int i = 0; i < arrPositive.length; i++) {
            arrPositive[i] = 0;
        }
        for(int i = 0; i < arrNegative.length; i++) {
            arrNegative[i] = 0;
        }

        for(int num : nums) {
            if(num >= 0) {
                arrPositive[num]++;
            } else {
                arrNegative[-num]++;
            }

        }
        int count = 0;

        for(int i = arrPositive.length - 1; i >= 0 ; i--) {
            count += arrPositive[i];
            if(count >= k) {
                return i;
            }
        }
        for(int i = 1; i < arrNegative.length; i++) {
            count += arrNegative[i];
            if(count >= k) {
                return -i;
            }
        }
        return -1;
    }
}

class FindKthLargestTest{
    public void test() {
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.find(nums1, 2));
        System.out.println(findKthLargest.find(nums2, 4));
    }


}