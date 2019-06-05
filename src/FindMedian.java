public class FindMedian {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*nums1, nums2其一为空*/
        if (nums1.length == 0) {
            return findMedianOfSingleArray(nums2);
        }
        if (nums2.length == 0) {
            return findMedianOfSingleArray(nums1);
        }

        int sumLengh = nums1.length + nums2.length;
        int middleIndex = sumLengh / 2;;
        int i = 0, j = 0;
        int record = 0;
        for(int k = 0; k < middleIndex; k++) {

            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] <= nums2[j]) {
                    record = nums1[i];
                    i++;

                    continue;
                }
                if(nums1[i] > nums2[j]) {
                    record = nums2[j];
                    j++;

                    continue;
                }
            }
            if(i == nums1.length) {
                record = nums2[j];
                j++;
            }
            if(j == nums2.length) {
                record = nums1[i];
                i++;
            }

        }
        if(sumLengh % 2 == 1) {
            if(i < nums1.length && j < nums2.length) {
                return (double) (nums1[i] <= nums2[j] ? nums1[i] : nums2[j]);
            }
            if(i == nums1.length) {
                return (double) nums2[j];
            }
            if(j == nums2.length) {
                return (double) nums1[i];
            }
        } else {
            if(i < nums1.length && j < nums2.length) {
                int min = (nums1[i] <= nums2[j] ? nums1[i] : nums2[j]);

                return (record + min) /2.0;
            }
            if(i == nums1.length) {
                return (nums2[j] + record) / 2.0;
            }
            if(j == nums2.length) {
                return (nums1[i] + record) / 2.0;
            }
        }
    return 0;
    }

    public double findMedianOfSingleArray(int arr[]) {
        if(arr.length % 2 == 0) {
            int n1 = arr[arr.length / 2];
            int n2 = arr[arr.length / 2 - 1];
            return (n1 + n2) / 2.0;

        }
        else {
            return (double) arr[arr.length / 2] ;
        }
    }

}

class FindMedianTest {

    public void test() {
        int[] nums1 = {};
        int[] nums2 = {1, 2};
        int[] nums3 = {-1, 3};
        FindMedian findMedian = new FindMedian();
        System.out.println(findMedian.findMedianSortedArrays(nums2, nums3));

    }
}