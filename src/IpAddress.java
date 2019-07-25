import java.util.ArrayList;
import java.util.List;

public class IpAddress {
    private List<String> addresses = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) {
            return addresses;
        }

        gerAddresses(s, 0, "", 0);
        return addresses;
    }

    private void gerAddresses(String s, int index, String address, int segmentNum) {
        if(segmentNum == 4) {
            if(index == s.length()) {
                addresses.add(address.substring(1));
            }
            return;             //回溯点1
        }
        //首段可最多分配的位数
        int count = Math.min(s.length() - index - (3 - segmentNum), 3);
       // System.out.println("count: " + count);

        for(int i = 1; i <= count; i++) {
            String num = s.substring(index, index + i);
            if(s.charAt(index) == '0' && i > 1) {
                return;           //回溯点2
            }
            if(Integer.parseInt(num) <= 255) {
                gerAddresses(s, index + i, address + "." + num, segmentNum + 1);

            }
            else {
                return;        //回溯点3
            }
        }

    }
}

class IpAddressTest {
    public void test() {
        String s = "010010";
        List<String> addresses = new IpAddress().restoreIpAddresses(s);
        for(int i = 0; i < addresses.size(); i++) {
            System.out.println(addresses.get(i));
        }
    }
}