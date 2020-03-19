package chapter1_exercise1to500.section1_exercise1to50;

public class Ex38_CountAndSay {
    public String countAndSay(int n) {
        if(n==1)return "1";
        String result="1";
        int count=1;
        StringBuilder sb=new StringBuilder();

        while(--n>0){
            for(int i=0;i<result.length();i++){
                while((i+1)<result.length()&&result.charAt(i)==result.charAt(i+1)){
                    i++;
                    count++;
                }
                sb.append(count+""+result.charAt(i));
                count=1;
            }
            result=sb.toString();
            sb=new StringBuilder();
        }
        return result;
    }
}
