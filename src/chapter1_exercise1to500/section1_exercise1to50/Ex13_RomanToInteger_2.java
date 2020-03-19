package chapter1_exercise1to500.section1_exercise1to50;

public class Ex13_RomanToInteger_2 {
    public int romanToInt(String s) {
        int i=0,v=0,x=0,l=0,c=0,d=0,m=0;
        char[] arr=s.toCharArray();
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]=='I') ++i;
            if(arr[j]=='V') {
                ++v;
                if(j-1>=0&&arr[j-1]=='I'){
                    i-=2;
                }
            }
            if(arr[j]=='X') {
                ++x;
                if(j-1>=0&&arr[j-1]=='I'){
                    i-=2;
                }
            }
            if(arr[j]=='L') {
                ++l;
                if(j-1>=0&&arr[j-1]=='X'){
                    x-=2;
                }
            }
            if(arr[j]=='C') {
                ++c;
                if(j-1>=0&&arr[j-1]=='X'){
                    x-=2;
                }
            }
            if(arr[j]=='D') {
                ++d;
                if(j-1>=0&&arr[j-1]=='C'){
                    c-=2;
                }
            }
            if(arr[j]=='M'){
                ++m;
                if(j-1>=0&&arr[j-1]=='C'){
                    c-=2;
                }
            }

        }
        int sum=i+v*5+x*10+l*50+c*100+d*500+m*1000;
        return sum;
    }
}
