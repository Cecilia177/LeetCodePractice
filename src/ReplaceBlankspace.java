import java.util.ArrayList;
import java.util.List;

public class ReplaceBlankspace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        char ch = ' ';
        for(int i = 0; i < str.length(); i++) {
            if(ch == str.charAt(i)) {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        List<Integer> list = new ArrayList<>();
        return sb.toString();
    }

}
