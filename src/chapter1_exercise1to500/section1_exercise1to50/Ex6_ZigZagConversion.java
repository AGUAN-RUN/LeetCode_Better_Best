package chapter1_exercise1to500.section1_exercise1to50;

public class Ex6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s==null||s.length()<=numRows||numRows==1)return s;
        int n=s.length();
        char [][] strings=new char[numRows][n];
        int row=0;
        int column=0;
        int rs=1;
        int cs=0;
        int temp=0;
        char [] result=new char[n];
        for(int i=0;i<n;i++){
            strings[row][column]=s.charAt(i);
            if(row==0){
                rs=1;
                cs=0;
            }
            if(row==(numRows-1)){
                rs=-1;
                cs=1;
            }
            row+=rs;
            column+=cs;
        }
        for(int i=0;i<strings.length;i++){
            for(int j=0;j<strings[i].length;j++){
                if(strings[i][j]!=0){
                    result[temp++]=strings[i][j];
                }
            }
        }
        return new String(result);
    }
}
