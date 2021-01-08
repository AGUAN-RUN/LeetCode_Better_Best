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

/*
你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：

你写出一个秘密数字，并请朋友猜这个数字是多少。
朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
朋友根据提示继续猜，直到猜出秘密数字。
请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。

xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。

 

示例 1:

输入: secret = "1807", guess = "7810"
输出: "1A3B"
解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
示例 2:

输入: secret = "1123", guess = "0111"
输出: "1A1B"
解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 

说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。


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
