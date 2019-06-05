public class FindMedian2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*nums1, nums2其一为空*/
        if (nums1.length == 0) {
            return new FindMedian().findMedianOfSingleArray(nums2);
        }
        if (nums2.length == 0) {
            return new FindMedian().findMedianOfSingleArray(nums1);
        }

        int[] arr = new int[(nums1.length + nums2.length) / 2 + 1];
        int i = 0, j = 0;
        for (int k = 0; k < arr.length; k++) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    arr[k] = nums1[i];
                    i++;
                    continue;
                }
                if (nums2[j] < nums1[i]) {
                    arr[k] = nums2[j];
                    j++;
                    continue;
                }
            }
            if (i == nums1.length) {
                arr[k] = nums2[j];
                j++;
                continue;
            }
            if (j == nums2.length) {
                arr[k] = nums1[i];
                i++;
                continue;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (arr[arr.length - 1] + arr[arr.length - 2]) / 2.0;
        } else {
            return arr[arr.length - 1];
        }
    }

}



class FindMedian2Test {

    public void test() {
        int[] nums2 = {1};
        int[] nums3 = {1};
        FindMedian2 findMedian2 = new FindMedian2();
        System.out.println(findMedian2.findMedianSortedArrays(nums2, nums3));

    }
}