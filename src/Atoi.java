public class Atoi {
    public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        while(i < arr.length && arr[i] == ' ') {
            i++;
        }
        boolean negative = false;
        if(i < arr.length && arr[i] !='+' && arr[i] != '-' && arr[i] < '0' && arr[i] > '9') {
            return 0;
        }

        if(i < arr.length &&  arr[i] =='-') {
            negative = true;
            i++;
        } else if (i < arr.length &&  arr[i] =='+') {
            i++;
        }


        int num = 0;
        if(negative) {
            while(i < arr.length && arr[i] >= '0' && arr[i] <= '9' && num >= Integer.MIN_VALUE / 10) {
                if(num == Integer.MIN_VALUE / 10 && arr[i] > '8' ) {
                    return Integer.MIN_VALUE;
                }
                num = -((-num) * 10 + (arr[i] - '0'));
                i++;


            }
        } else {
            while(i < arr.length && arr[i] >= '0' && arr[i] <= '9' && num <= Integer.MAX_VALUE / 10) {
                if(num == Integer.MAX_VALUE / 10 && arr[i] > '7') {
                    return Integer.MAX_VALUE;
                }
                num = num * 10 + (arr[i] - '0');
                System.out.println(num);
                i++;


            }
        }
        System.out.println("MAX_VALUE:" + Integer.MAX_VALUE);
        if(i < arr.length && arr[i] >= '0' && arr[i] <= '9') {
            System.out.println("beyond boundary");
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return num;


    }
}

class AtoiTest {
    public void test() {
        Atoi atoi = new Atoi();
//        System.out.println(atoi.myAtoi("42"));
//        System.out.println(atoi.myAtoi("   -42"));
//        System.out.println(atoi.myAtoi("4298 with words"));
//        System.out.println(atoi.myAtoi("  words 897"));
//        System.out.println(atoi.myAtoi(" -4342"));
        System.out.println(atoi.myAtoi("2147483648"));
    }
}