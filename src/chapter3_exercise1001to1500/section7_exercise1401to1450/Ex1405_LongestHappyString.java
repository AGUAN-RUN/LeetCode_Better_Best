package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string ""

Constraints:
0 <= a, b, c <= 100
a + b + c > 0
*/
public class Ex1405_LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        int fa=0;
        int fb=0;
        int fc=0;
        int time=a+b+c;
        StringBuilder builder=new StringBuilder("");
        for(int i=0;i<time;i++){
            if(a==0&&b==0&&fc==2)return builder.toString();
            if(b==0&&c==0&&fa==2)return builder.toString();
            if(a==0&&c==0&&fb==2)return builder.toString();
            if(a>=b&&a>=c&&fa<2){
                builder.append("a");
                a--;
                fa++;
                fb=0;
                fc=0;
            }else if(a>=b&&a>=c&&fa==2){
                if(b>=c){
                    builder.append("b");
                    b--;
                    fb++;
                    fa=0;
                    fc=0;
                }else {
                    builder.append("c");
                    c--;
                    fc++;
                    fa=0;
                    fb=0;
                }
            }else if(b>=a&&b>=c&&fb<2){
                builder.append("b");
                b--;
                fb++;
                fa=0;
                fc=0;
            }else if(b>=a&&b>=c&&fb==2){
                if(a>=c){
                    builder.append("a");
                    a--;
                    fa++;
                    fb=0;
                    fc=0;
                }else {
                    builder.append("c");
                    c--;
                    fc++;
                    fa=0;
                    fb=0;
                }
            }else if(c>=a&&c>=b&&fc<2){
                builder.append("c");
                c--;
                fc++;
                fa=0;
                fb=0;
            }else {
                if(a>b){
                    builder.append("a");
                    a--;
                    fa++;
                    fb=0;
                    fc=0;
                }else {
                    builder.append("b");
                    b--;
                    fb++;
                    fa=0;
                    fc=0;
                }
            }
        }
        return builder.toString();
    }
}
