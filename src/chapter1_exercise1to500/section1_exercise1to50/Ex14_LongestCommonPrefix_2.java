package chapter1_exercise1to500.section1_exercise1to50;

public class Ex14_LongestCommonPrefix_2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs[0].length();
        for (int i=1; i<strs.length && len>0; i++) {
            int secLen = strs[i].length();
            if (secLen <= len) {
                len = secLen;
            }
            while (len>0) {
                if (strs[0].substring(0,len).equals(strs[i].substring(0,len))) {
                    break;
                } else {
                    len--;
                }
            }
        }
        return strs[0].substring(0, len);
    }
}
