package chapter1_exercise1to500.section1_exercise1to50;

public class Ex5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null||s.equals("")||s.length()==1)return s;
        char[]crs=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int left=0;
        int right=0;
        for(int i=0;i<crs.length;i++){
            int j=i-1;
            int k=i+1;
            while(j>=0&&k<crs.length&&crs[j]==crs[k]){
                j-=1;
                k+=1;
            }
            if((k-j-2)>=(right-left)){
                right=k-1;
                left=j+1;
            }
        }
        for(int i=0;i<crs.length;i++){
            int j=i;
            int k=i+1;
            while(j>=0&&k<crs.length&&crs[j]==crs[k]){
                j-=1;
                k+=1;
            }
            if((k-j-2)>=(right-left)){
                right=k-1;
                left=j+1;
            }
        }
        for(int i=left;i<=right;i++){
            sb.append(crs[i]);
        }

        return sb.toString();
    }
}
