package chapter1_exercise1to500.section1_exercise1to50;

public class Ex14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        StringBuffer sb=new StringBuffer("");
        char a;
        for(int k=0;k<strs[0].length();k++){
            a=strs[0].charAt(k);
            for(int i=1;i<strs.length;i++){
                if(strs[i].length()<k+1){
                    return sb.toString();
                }
                if(strs[i].charAt(k)==a){
                    continue;
                }else{
                    return sb.toString();
                }
            }
            sb.append(a);
        }
        return sb.toString();
    }
}
