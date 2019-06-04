public class RainDrop {

    public int trap(int[] height) {

        /*1. 查找数组中呈凹字形的数字，存储水量为较小差值
        * */
        if(height.length <= 2) {
            return 0;
        }
        int count = 0;
        int heap = height[0];
        int heapIndex = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] > heap) {
                heap = height[i];
                heapIndex = i;
            }
        }
        int temp = height[0];
        for(int i = 1; i < heapIndex; i++) {
            if(height[i] > temp) {
                temp = height[i];
            }
            else {
                count += (temp - height[i]);
            }
        }
        temp = height[height.length-1];
        for(int i = height.length-2; i > heapIndex; i--) {
            if(height[i] > temp) {
                temp = height[i];
            }
            else {
                count += (temp - height[i]);
            }
        }

        return count;
    }

    public int getMuti(int min, int left, int right, int[] height) {
        int muti = 0;
        int base = (height[left] > height[right] ? height[right] : height[left]);
        for(int i = left+1; i < right; i++) {
            muti += (base - height[i]);
        }
        return muti;
    }
}

class RainDropTest {
    public void test() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = new int[]{4,2,3};
        RainDrop rainDrop = new RainDrop();
        System.out.println(rainDrop.trap(height));
        System.out.println(rainDrop.trap(height1));
    }

}
