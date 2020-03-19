package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.List;

public class Ex22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if(n<0)return null;
        List<String> result=new ArrayList<>();
        if(n==0)return result;
        result.add("(");
        int left=n-1;
        int right=n;
        return recursionList(result,left,right);
    }

    public List<String> recursionList(List<String>st,int le,int rt){
        List<String>relt=new ArrayList<>();
        List<String>listLeft =new ArrayList<String>();
        List<String>listRight=new ArrayList<String>();
        if(le<rt){
            if(le>0){
                for(int i=0;i<st.size();i++){
                    listLeft.add(st.get(i)+"(");
                }
                listLeft=recursionList(listLeft,le-1,rt);
            }
            if(rt>0){
                for(int i=0;i<st.size();i++){
                    listRight.add(st.get(i)+")");
                }
                listRight=recursionList(listRight,le,rt-1);
            }
        }
        if(le==rt){
            if(le!=0){
                for(int i=0;i<st.size();i++){
                    listLeft.add(st.get(i)+"(");
                }
                listLeft=recursionList(listLeft,le-1,rt);
            }
            if(le==0){
                return st;
            }
        }
        listLeft.addAll(listRight);
        return listLeft;
    }
}
