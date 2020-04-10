package chapter1_exercise1to500.section3_exercise101to150;
/*
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.
* */
public class Ex125_ValidPalindrome {
    //只统计数字和字母，字母不区分大小写

    //用时1ms  击败99.99%
    public boolean isPalindrome(String s) {
        if(s==null||s.length()<2)return true;
        char[]strs=s.toCharArray();
        int m=strs.length-1;
        //数字  48-57  大写字母 65-90  小写字母97-122
        for(int i=0;i<m;i++){
            if(strs[i]<=57&&strs[i]>=48){
                for(int j=m;j>=i;j--){
                    if((strs[j]<=90&&strs[j]>=65)||(strs[j]<=122&&strs[j]>=97))return false;
                    if((strs[j]>=48&&strs[j]<=57)){
                        if(strs[j]!=strs[i])return false;
                        m=j-1;
                        break;
                    }
                }
            }else if(strs[i]<=90&&strs[i]>=65){
                for(int j=m;j>=i;j--){
                    if((strs[j]>=48&&strs[j]<=57))return false;
                    if((strs[j]<=90&&strs[j]>=65)||(strs[j]<=122&&strs[j]>=97)){
                        if(strs[j]!=strs[i]&&(strs[i]+32)!=strs[j])return false;
                        m=j-1;
                        break;
                    }
                }
            }else if(strs[i]<=122&&strs[i]>=97){
                for(int j=m;j>=i;j--){
                    if((strs[j]>=48&&strs[j]<=57))return false;
                    if((strs[j]<=90&&strs[j]>=65)||(strs[j]<=122&&strs[j]>=97)){
                        if(strs[j]!=strs[i]&&(strs[i]-32)!=strs[j])return false;
                        m=j-1;
                        break;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        Ex125_ValidPalindrome test= new Ex125_ValidPalindrome();
        test.isPalindrome(s);
    }
}
