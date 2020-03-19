package chapter1_exercise1to500.section1_exercise1to50;

public class Ex38_CountAndSay_2 {
    public String countAndSay(int n) {
        if(n==1)return "1";
        char[]result;
        int count=1;
        StringBuilder sb=new StringBuilder("1");
        while(--n>0){
            result=sb.toString().toCharArray();
            sb=new StringBuilder();
            for(int i=0;i<result.length;i++){
                while((i+1)<result.length&&result[i]==result[i+1]){
                    i++;
                    count++;
                }
                sb.append(count+""+result[i]);
                count=1;
            }
        }
        return sb.toString();
    }
}
