package chapter1_exercise1to500.section6_exercese251to300;
/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is.
Each time your friend makes a guess,
you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls")
and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses
and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
* */
public class Ex299_BullsAndCows {
    //用时6ms  击败了80%
    public String getHint(String secret, String guess) {
        if(secret==null||guess==null||secret.length()==0||guess.length()==0)return "";
        int []nums1=new int[10];
        int []nums2=new int[10];

        char[]c1=secret.toCharArray();
        char[]c2=guess.toCharArray();

        int A=0,B=0;
        //统计数字猜对了，位置也对了的数的数目
        for(int i=0;i<c1.length;i++){
           nums1[c1[i]-'0']++;
           nums2[c2[i]-'0']++;
           if(c1[i]==c2[i])A++;
        }
        //统计猜对了的数字总数
        for(int i=0;i<nums1.length;i++){
            B+=Math.min(nums1[i],nums2[i]);
        }
        //数字猜对了但是位置不对的数字数目=猜对了的数字总数-数字猜对了，位置也对了的数的数目
        return A+"A"+(B-A)+"B";
        //就四个字符串相加  StringBuilder的效率也要比  使用  +  拼接  高出不少啊

        //return A+"A"+(B-A)+"B";  这一行优化为以下写法后  用时2ms！ 击败94%！！！
        // StringBuilder sb=new StringBuilder();
        // return sb.append(A).append("A").append(B-A).append("B").toString();
    }
}
