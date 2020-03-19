package chapter1_exercise1to500.section1_exercise1to50;

public class Ex13_RomanToInteger {
    public int romanToInt(String s) {
        int res=0;
        int tem=0;
        int max=s.length();
        if(s==null||s==""){
            return res;
        }
        while(tem<max&&s.charAt(tem)=='M'){
            res+=1000;
            if(res>3999)return 0;
            tem+=1;
        }
        while((tem+1)<max&&s.charAt(tem)=='C'&&s.charAt(tem+1)=='M'){
            res+=900;
            if(res>3999)return 0;
            tem+=2;
        }
        while(tem<max&&s.charAt(tem)=='D'){
            res+=500;
            if(res>3999)return 0;
            tem+=1;
        }
        while((tem+1)<max&&s.charAt(tem)=='C'&&s.charAt(tem+1)=='D'){
            res+=400;
            if(res>3999)return 0;
            tem+=2;
        }
        while(tem<max&&s.charAt(tem)=='C'){
            res+=100;
            if(res>3999)return 0;
            tem+=1;
        }
        while((tem+1)<max&&s.charAt(tem)=='X'&&s.charAt(tem+1)=='C'){
            res+=90;
            if(res>3999)return 0;
            tem+=2;
        }
        while(tem<max&&s.charAt(tem)=='L'){
            res+=50;
            if(res>3999)return 0;
            tem+=1;
        }
        while((tem+1)<max&&s.charAt(tem)=='X'&&s.charAt(tem+1)=='L'){
            res+=40;
            if(res>3999)return 0;
            tem+=2;
        }
        while(tem<max&&s.charAt(tem)=='X'){
            res+=10;
            if(res>3999)return 0;
            tem+=1;
        }
        while((tem+1)<max&&s.charAt(tem)=='I'&&s.charAt(tem+1)=='X'){
            res+=9;
            if(res>3999)return 0;
            tem+=2;
        }
        while(tem<max&&s.charAt(tem)=='V'){
            res+=5;
            if(res>3999)return 0;
            tem+=1;
        }
        while((tem+1)<max&&s.charAt(tem)=='I'&&s.charAt(tem+1)=='V'){
            res+=4;
            if(res>3999)return 0;
            tem+=2;
        }
        while(tem<max&&s.charAt(tem)=='I'){
            res+=1;
            if(res>3999)return 0;
            tem+=1;
        }

        return res;
    }
}
